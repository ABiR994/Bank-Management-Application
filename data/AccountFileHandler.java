package data;
import java.io.*;

public class AccountFileHandler {

    private static final String FILE_NAME = "accounts.txt";

    //! Save account
    public static void saveAccount(String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //! Read all accounts
    public static BufferedReader readAccounts() throws IOException {
        return new BufferedReader(new FileReader(FILE_NAME));
    }

    //! Account Validation
    public static String validateAccount(String accNo, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(accNo) && data[2].equals(password)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //! Find account
    public static String findAccount(String accNo) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(accNo)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
