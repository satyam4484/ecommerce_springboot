// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final AuthService authService;
//     private final CurrentUserService currentUserService; // or use SecurityContext directly

//     public AuthController(AuthService authService,
//                           CurrentUserService currentUserService) {
//         this.authService = authService;
//         this.currentUserService = currentUserService;
//     }

//     @PostMapping("/register")
//     public AuthResponse register(@RequestBody RegisterRequest request) {
//         return authService.register(request);
//     }

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody LoginRequest request) {
//         return authService.login(request);
//     }

//     @PostMapping("/refresh")
//     public AuthResponse refresh(@RequestBody RefreshTokenRequest request) {
//         return authService.refreshToken(request);
//     }

//     @PostMapping("/logout")
//     public void logout() {
//         Long userId = currentUserService.getCurrentUserId();
//         authService.logout(userId);
//     }

//     @PostMapping("/change-password")
//     public void changePassword(@RequestBody ChangePasswordRequest request) {
//         Long userId = currentUserService.getCurrentUserId();
//         authService.changePassword(userId, request);
//     }

//     @GetMapping("/me")
//     public UserProfileResponse me() {
//         // You can create a DTO for this
//         Long userId = currentUserService.getCurrentUserId();
//         // fetch from UserService
//         return null;
//     }
// }
