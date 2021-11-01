package OOP5;

public class AuthController {
    private UserRepository _userRepository; //тут лучше интерфейс репы
    private JwtService _jwtService; // и тут лучше интерфейс сервиса
    public AuthController(
            UserRepository repository,
            JwtService jwtService
    ){
        _userRepository = repository;
        _jwtService = jwtService;
    }

    public TokensModel SignUp(String email, String password){
        var userFromDb =_userRepository.GetByEmail(email);

        if (userFromDb != null) return null;

        var user = new User(email, password);

        _userRepository.Insert(user);

        var tokens = _jwtService.GenerateAccessToken(user);

        return tokens;
    }
    public TokensModel SignIn(String email, String password){
        var user = _userRepository.GetByEmail(email);

        if (user == null) return null;

        var inputUser = new User(email, password);

        if (!user.equals(inputUser)) return null;

        var tokens = _jwtService.GenerateAccessToken(user);

        return tokens;
    }
}
