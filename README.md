# Spring AOP Demo Lab

## Overview

This project demonstrates the basics of Aspect-Oriented Programming (AOP) using Spring Framework and AspectJ. It is a simple lab exercise to show how cross-cutting concerns (like logging) can be separated from business logic using aspects.

## Project Structure

```
spring-aop-demo/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── roczyno/
│       │           ├── BeanConfig.java
│       │           ├── LoggingAspect.java
│       │           ├── Main.java
│       │           └── ShoppingCart.java
│       └── resources/
└── README.md
```

## Technologies Used

- Java 17
- Spring Framework (spring-context)
- AspectJ (aspectjrt, aspectjweaver)
- Maven (for build and dependency management)

## What This Lab Demonstrates

- **Spring AOP**: Using `@Aspect` and `@Before` to inject logging before a business method.
- **Component Scanning**: Using `@ComponentScan` to automatically detect beans.
- **Java-based Configuration**: No XML, all configuration is done using annotations.

## How It Works

- The `ShoppingCart` class is a simple Spring component with a `checkout()` method.
- The `LoggingAspect` class is an aspect that logs a message before `ShoppingCart.checkout()` is called.
- The `Main` class bootstraps the Spring context, retrieves the `ShoppingCart` bean, and calls `checkout()`.

## Setup and Running the Lab

1. **Clone the repository** (if not already):
   ```bash
   git clone <repo-url>
   cd spring-aop-demo
   ```
2. **Build the project with Maven:**
   ```bash
   mvn clean install
   ```
3. **Run the Main class:**
   - Using your IDE: Run `com.roczyno.Main`.
   - Or from command line (after build):
     ```bash
     mvn exec:java -Dexec.mainClass="com.roczyno.Main"
     ```

## Code Walkthrough

### 1. BeanConfig.java

```java
@Configuration
@ComponentScan(basePackages = "com.roczyno")
@EnableAspectJAutoProxy
public class BeanConfig {}
```

- Enables component scanning and AOP proxying.

### 2. ShoppingCart.java

```java
@Component
public class ShoppingCart {
    public void checkout(){
        System.out.println("Checkout method from shoppping cart called");
    }
}
```

- A simple Spring bean with a checkout method.

### 3. LoggingAspect.java

```java
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.roczyno.ShoppingCart.checkout())")
    public void logger(){
        System.out.println("Loggers");
    }
}
```

- This aspect logs "Loggers" before `ShoppingCart.checkout()` executes.

### 4. Main.java

```java
public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(BeanConfig.class);
        ShoppingCart cart=context.getBean(ShoppingCart.class);
        cart.checkout();
    }
}
```

- Bootstraps the Spring context and triggers the aspect.

## Expected Output

When you run the `Main` class, you should see:

```
Loggers
Checkout method from shoppping cart called
```

## How to Extend This Lab

- Add more methods to `ShoppingCart` and create new aspects (e.g., for security, transactions).
- Use other AOP advices: `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around`.
- Inject dependencies into aspects.

## Troubleshooting

- **No output from aspect?** Ensure you are running with the correct Spring and AspectJ dependencies and that `@EnableAspectJAutoProxy` is present.
- **Class not found errors?** Make sure Maven dependencies are downloaded (`mvn clean install`).

## License

This lab is for educational purposes.
