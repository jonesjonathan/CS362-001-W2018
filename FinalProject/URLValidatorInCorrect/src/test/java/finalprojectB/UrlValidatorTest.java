
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


//Jonathan Jones: jonesjon ------ Jillian Emard: emardj


public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {
     System.out.println("\n----------\nMANUAL TESTING\n----------\n");
     //You can use this function to implement your manual testing
     UrlValidator validator1 = new UrlValidator(); //Default Schemes enabled
     UrlValidator validator2 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES); //All schemes enabled
     validator1.isValid("http://www.google.com"); //Finds the UPPERCASE error
     validator1.isValid("https://example.org/absolute/URI/with/absolute/path/to/resource.txt");
     validator1.isValid("file://localhost/c:/WINDOWS/clock.avi");
     validator2.isValid("file://localhost/c:/WINDOWS/clock.avi"); //Catches the regex != error, traceable through exception thrown
     validator2.isValid("https://example.org/absolute/URI/with/absolute/path/to/resource.txt");
     validator2.isValid("http://www.google.com");
   }


   public void testYourFirstPartition()
   {
	   //You can use this function to implement your First Partition testing
     //VALID URLS
     System.out.println("\n----------\nTesting first partition\n----------\n");

     UrlValidator validator = new UrlValidator();
     //These are boundary cases for ip adresses and ports (VALID)
     String[] urls = {"https://255.255.255.255:65535/example/index.html?action=view",
     "https://0.0.0.0:65535/example/index.html?action=view", "https://255.255.255.255:0/example/index.html?action=view",
     "https://0.0.0.0:0/example/index.html?action=view"};

     for(int i = 0; i < urls.length; i++)
     {
       System.out.println(urls[i]);
       assertTrue(validator.isValid(urls[i]));
     }

   }

   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
     //INVALID URLS
     System.out.println("\n----------\nTesting second partition\n----------\n");

     UrlValidator validator = new UrlValidator();
     //These are boundary cases for ip adresses and ports (VALID)
     String[] urls = {"https://256.256.256.256:65535/example/index.html?action=view",
     "https://-1.-1.-1.-1:65535/example/index.html?action=view", "https://255.255.255.255:65636/example/index.html?action=view",
     "https://255.255.255.255:-1/example/index.html?action=view"};

     for(int i = 0; i < urls.length; i++)
     {
       System.out.println(urls[i]);
       assertFalse(validator.isValid(urls[i]));
     }

   }
   //You need to create more test cases for your Partitions if you need to

   public void testIsValid()
   {
     //You can use this function for programming based testing

     //Scheme, authority, (host, port), path, query
     UrlValidator testURL = new UrlValidator();
     //Collection of valid cases, all should be true when tested on is valid
     String[] validCases = {"http://tech.yahoo.com/rc/desktops/102;_ylt=Ao8yevQHlZ4On0O3ZJGXLEQFLZA5",
                            "http://www.google.com","ftp://go.com","http://255.255.255.255/test1?action=view",
                            "http://go.au","http://go.au/test1/file?action=view","http://go.au/test1/file?action=edit&mode=up",
                            "http://go.au/test1/file","http://0.0.0.0:80/test1?action=view","http://0.0.0.0:80/test1?action=edit&mode=up",
                            "http://0.0.0.0:80/test1","http://0.0.0.0:80/t123?action=view","http://0.0.0.0:80/t123?action=edit&mode=up",
                            "http://0.0.0.0:80/t123", "ftp://go.au?action=edit&mode=up","ftp://go.au","ftp://go.au/test1/file?action=view",
                            "ftp://go.au/test1/file?action=edit&mode=up","ftp://go.au/test1/file","ftp://0.0.0.0:80/test1?action=view",
                            "ftp://0.0.0.0:80/test1?action=edit&mode=up","ftp://0.0.0.0:80/test1","h3t://www.google.com/test1/file?action=view",
                            "h3t://www.google.com/test1/file?action=edit&mode=up","h3t://www.google.com/test1/file","h3t://go.com:80/test1?action=view",
                            "h3t://go.com:80/test1?action=edit&mode=up","h3t://go.com:80/test1"};

    //Loops through the array of URL's and tests for validity
    for(int i = 0; i < validCases.length; i++){
        assertTrue(testURL.isValid(validCases[i]));
    }

     //Collection of invalid cases, all should be false when tested on is valid
     String[] invalidCases = {"http://www.google.com:80/..?action=view", "http://www.google.com:80/..?action=edit&mode=up",
                              "http://www.google.com:80/..","http://www.google.com:80/../?action=view", "http://www.google.com:80/../?action=edit&mode=up",
                              "http://www.google.com:80/../", "3ht://:65636","3ht://:65636/test1/file?action=view", "3ht://:65636/test1/file?action=edit&mode=up"
                              ,"3ht://:65636/test1/file","3ht://:65636/..//file?action=view","3ht://:65636/..//file?action=edit&mode=up","3ht://:65636/..//file", "3ht://:65636/test1//file?action=view",
                              "3ht://:65636/test1//file?action=edit&mode=", "ftp://aaa:-1/../?action=edit&mode=up","ftp://aaa:-1/../","ftp://aaa:-1/test1/?action=view"
                              ,"ftp://aaa:-1/test1/?action=edit&mode=up","ftp://aaa:-1/test1/","ftp://aaa:-1?action=view","ftp://aaa:-1?action=edit&mode=up","ftp://aaa:-1"};

    //Loops through the array of URL's and tests for invalidity
    for(int i = 0; i < invalidCases.length; i++){
        assertFalse(testURL.isValid(invalidCases[i]));
    }

   }



}
