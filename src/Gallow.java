public class Gallow {
    public static void drawGallow(int healthPoints) {
        String result;
        switch(healthPoints) {
            case 6:
                result = """
                        
                        ####
                           #
                           #
                           #
                          ###
                        """;
                System.out.println(result);
                break;
            case 5:
                result = """
                        
                        ####
                        0  #
                           #
                           #
                          ###
                        """;
                System.out.println(result);
                break;
            case 4:
                result = """
                        
                        ####
                        0  #
                        |  #
                           #
                          ###
                        """;
                System.out.println(result);
                break;
            case 3:
                result = """
                         
                         ####
                         0  #
                         |\\ #
                            #
                           ###
                        """;
                System.out.println(result);
                break;
            case 2:
                result = """
                         
                         ####
                         0  #
                        /|\\ #
                            #
                           ###
                        """;
                System.out.println(result);
                break;
            case 1:
                result = """
                         
                         ####
                         0  #
                        /|\\ #
                        /   #
                           ###
                        """;
                System.out.println(result);
                break;
            case 0:
                result = """
                         
                         ####
                         0  #
                        /|\\ #
                        / \\ #
                           ###
                        """;
                System.out.println(result);
                break;
        }
    }
}
