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
## LAB 16:

1.The site should allow users to create an ApplicationUser on the “sign up” page

2.our Controller should have an @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder; and use that to run bCryptPasswordEncoder.encode(password) before saving the password into the new user

3.The site should have a page which allows viewing the data about a single

4.The site should use reusable templates for its information. (At a minimum, it should have one Thymeleaf fragment that is used on multiple pages.)


5.The site should be well-styled and attractive.

6.The site should have a non-whitelabel error handling page that lets the user know, at minimum, the error code and a brief message about what went wrong

##Pending:
3.The site should contain integration testing. At a minimum, there should be tests to ensure basic functionality for the splash page and the sign up page

## LAB 17:

1.Upon logging in, users should be taken to a /myprofile route that displays their information

2.Ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.

3.Ensure that user registration also logs users into your app automatically.

4.Add a Post entity to your app.

5.A user’s posts should be visible on their profile page
6.When a user is logged in, the app should display the user’s username on every page (probably in the heading

## LAB 18:
1.Ensure that users can’t perform SQL injection or HTML injection with their posts.

2.Allow users to follow other users. Following a user means that their posts show up in the logged-in user’s feed, where they can see what all of their followed users have posted recently.

3.On a user profile page that does NOT belong to the currently logged-in user, display a “Follow” button. When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.

4.A user can visit a url (like /feed) to view all of the posts from the users that they follow.



