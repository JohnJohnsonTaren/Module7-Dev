package behavior.db;// Завдання №2 - створити клас для ініціалізації структури БД
// Створи клас з назвою BehaviorDB.DatabaseInitService.
// У цьому класі має бути метод public static void main(String[] args),
//      який зчитуватиме файл sql/init_db.sql і виконуватиме запити з цього класу у БД.
//
// Для роботи з БД використовуй написаний раніше тобою клас BehaviorDB.Database.
// Результат запуску цього класу - проініцалізована база даних
//      з коректно створеними таблицями та зв'язками між цими таблицями.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class DatabaseInitService {
    public static void main(String[] args) throws IOException, SQLException {
        String sql = Files.readString(Path.of("sql/init_db.sql"));

        Connection connection = null;
        try {
            connection = Database.getInstance().getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.execute();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

