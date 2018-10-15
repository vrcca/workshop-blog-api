# Blog API
This is the API for the React JS + Spring Boot + Docker Workshop.

## Running This Application
Make sure you have at least JDK 8+ installed.
1. Clone the project: `git clone git@github.com:vrcca/workshop-blog-api.git`
2. Run the project with: `./gradlew clean bootRun`
3. Test to check that the application is running properly:
`curl http://localhost:8080/posts`

## Coding This Project
1. Install gradle: `brew install gradle`
2. Create a new project with: `gradle init --type java-application`
3. Add the Spring boot dependencies to `build.gradle`:
    ```groovy
    plugins {
      id 'java'
      id 'org.springframework.boot' version '2.0.5.RELEASE'
    }
    
    dependencies {
        compile 'org.springframework.boot:spring-boot-starter-web:2.0.5.RELEASE'
        // ...
    }
    ```
    Delete `application` plugin and the `mainClassName` property.
4. Create a default package such as `com.github.yourusername.blogapi` and move `App.java` into it.
5. Start Spring Boot in `App.java`:
   ```java
   @EnableAutoConfiguration // tells spring to autosetup
   @ComponentScan // scans for @annotations in classes
   public class App {
       public static void main(String[] args) {
           SpringApplication.run(App.class, args); // starts Spring 
       }
   }
   ```
6. Create the `BlogPost` class with fields `id`, `title` and `description`.
7. Create a class named `PostsController` and annotate it with `@RestController`
8. Create the endpoints in `PostController.java`:
    ```java
    @RestController
    public class PostsController {

        @GetMapping("/posts")
        public ResponseEntity<List<BlogPost>> listPosts() {
            return ResponseEntity.ok(new ArrayList<>());
        }
    }
    ```
9. Run the application with `./gradlew bootRun`
10. Test it with `curl http://localhost:8080/posts`