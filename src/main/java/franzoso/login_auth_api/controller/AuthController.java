package franzoso.login_auth_api.controller;

import franzoso.login_auth_api.domain.user.User;
import franzoso.login_auth_api.dto.LoginRequestDTO;
import franzoso.login_auth_api.dto.RegisterRequestDTO;
import franzoso.login_auth_api.dto.ResponseDTO;
import franzoso.login_auth_api.infra.security.TokenService;
import franzoso.login_auth_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO requestDTO) {
        User user = userRepository.findByEmail(requestDTO.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(requestDTO.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO requestDTO){
        Optional<User> user = this.userRepository.findByEmail(requestDTO.email());

        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(requestDTO.password()));
            newUser.setEmail(requestDTO.email());
            newUser.setName(requestDTO.name());
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}
