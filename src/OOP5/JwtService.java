package OOP5;

import java.util.Random;

//Класс для генерации JWT токенов но для упрощения будет просто какой-то набор символов
public class JwtService {
    public TokensModel GenerateAccessToken(User user){
        //OOP5.User тут для генерации claims для токена

        var tokenBuilder = new StringBuilder();
        var rnd = new Random();
        for (int i = 0; i < 36; i++){
            tokenBuilder.append((char)(rnd.nextInt(26) + 65));
        }

        return new TokensModel(tokenBuilder.toString());
    }
}
