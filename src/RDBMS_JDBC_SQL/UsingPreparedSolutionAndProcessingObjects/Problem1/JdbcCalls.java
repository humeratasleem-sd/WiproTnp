package RDBMS_JDBC_SQL.UsingPreparedSolutionAndProcessingObjects.Problem1;

public class JdbcCalls {

    public static void main(String[] args) throws Exception {

        DAOClass dao = new DAOClass();

        int option = Integer.parseInt(args[0]);

        switch(option)
        {
            case 1:
                dao.insert(
                        Integer.parseInt(args[1]),   // Roll No
                        args[2],                     // Name
                        Integer.parseInt(args[3]),   // Marks
                        args[4],                     // DOB
                        Integer.parseInt(args[5])    // Fees
                );
                break;

            case 2:
                dao.delete(Integer.parseInt(args[1]));
                break;

            case 3:
                dao.modify(
                        Integer.parseInt(args[1]),
                        Integer.parseInt(args[2]));
                break;

            case 4:

                if(args.length == 2)
                    dao.display(Integer.parseInt(args[1]));
                else
                    dao.display();

                break;
        }
    }
}