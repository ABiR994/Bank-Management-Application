package data;
import java.io.*;
import model.*;
import utils.*;

public class AccountFileHandler {

    private static final String FILE_NAME = "./data/accounts.txt";
    private static final String TEMP_FILE_NAME = "./data/temp.txt";

    //! Save account
    public static void saveAccount(Account account) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String data = Utils.accountToLine(account);
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    //! Read all accounts
    public static BufferedReader readAccounts() throws IOException {
        return new BufferedReader(new FileReader(FILE_NAME));
    }

    //! Account Validation
    public static Account validateAccount(String accNo, String password) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                Account account = Utils.lineToAccount(line);

                if (account != null && account.getAccNo().equals(accNo) && account.getPassword().equals(password)) {
                    return account;
                }
            }
        } catch (IOException e) {
            System.out.println("Error validating account: " + e.getMessage());
        }

        return null;
    }

    //! Find account
    public static Account findAccount(String accNo) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                Account account = Utils.lineToAccount(line);

                if (account != null && account.getAccNo().equals(accNo)) {
                    return account;
                }
            }
        } catch (IOException e) {
            System.out.println("Error finding account: " + e.getMessage());
        }
        return null;
    }

    //! Delete account
    public static void deleteAccount(String accNo) {

        File originalFile = new File(FILE_NAME);
        File tempFile = new File(TEMP_FILE_NAME);

        try (
            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                Account account = Utils.lineToAccount(line);

                //! write only the accounts that are not going to be deleted
                if (account != null && !account.getAccNo().equals(accNo)) {
                    bw.write(Utils.accountToLine(account));
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Account file not found: " + e.getMessage());
        }catch (IOException e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }

        //! replace old file with new file
        originalFile.delete();
        tempFile.renameTo(originalFile);
    }

    //! Update account
    public static void updateAccount(Account accountData) {

        File originalFile = new File(FILE_NAME);
        File tempFile = new File(TEMP_FILE_NAME);

        try (
            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                Account account = Utils.lineToAccount(line);

                //! update the balance of the account
                if (account != null) {
                    if (account.getAccNo().equals(accountData.getAccNo())) {
                        account = accountData;
                    }
                    bw.write(Utils.accountToLine(account));
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Account file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error updating account: " + e.getMessage());
        }

        //! replace old file with new file
        originalFile.delete();
        tempFile.renameTo(originalFile);
    }


}
