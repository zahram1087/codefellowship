<!-- What approach did you take? -->
I approached this lab reviewing how to do a controller.I also reviewed thymleaf dialects.


<!-- Description of each method publicly available to your Stack and Queue-->
##ApplicationUserController CLASS:
1. A user should be able to see information about all the the other users.
2. A user should be able to sign up.
3. RequestMapping to render a DB
"http://localhost:8080/"
"http://localhost:8080/signup"
"http://localhost:8080/signup/{id}"

##Runing App:

##1.Load the following application properties:

    spring.datasource.platform=postgres
    spring.datasource.url=jdbc:postgresql://localhost:YOUR_DATABASE_NUMBER/DATABASE_NAME
    spring.datasource.username=USER_NAME
    spring.datasource.password=PASSWORD

2. Remember to remove the spring.jpa.hibernate.ddl-auto = create from the application properties after the first run so that database doesn't get wiped clean
3. Run ./gradlew bootRun
4. Go to:
    http://localhost:8080/ -to get started

## STATE of FEATURED TASKS:
DONE:

1.The site should allow users to create an ApplicationUser on the “sign up” page

2.our Controller should have an @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder; and use that to run bCryptPasswordEncoder.encode(password) before saving the password into the new user

3.The site should have a page which allows viewing the data about a single

4.The site should use reusable templates for its information. (At a minimum, it should have one Thymeleaf fragment that is used on multiple pages.)

PENDING:

1.The site should be well-styled and attractive.

2.The site should have a non-whitelabel error handling page that lets the user know, at minimum, the error code and a brief message about what went wrong

3.The site should contain integration testing. At a minimum, there should be tests to ensure basic functionality for the splash page and the sign up page