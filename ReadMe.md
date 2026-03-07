Login Request
│
▼
SecurityFilterChain
│
▼
AuthenticationManager
│
▼
AuthenticationProvider (DaoAuthenticationProvider)
│
▼
UserDetailsService
│
▼
Database
│
▼
PasswordEncoder verifies password
│
▼
Authentication Success / Failure

securityConfig.java --> MyUSerDetailService.java --> UserPrinciple

spring-security-app/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/example/spring_security/
│ │ │ ├── config/
│ │ │ │ └── SecurityConfig.java # Security setup, roles, auth rules
│ │ │ │
│ │ │ ├── controller/
│ │ │ │ └── UserController.java # Register/login endpoints, test endpoints
│ │ │ │
│ │ │ ├── model/
│ │ │ │ ├── User.java # User entity with username, password, role
│ │ │ │ └── UserPrinciple.java # Implements UserDetails
│ │ │ │
│ │ │ ├── repo/
│ │ │ │ └── UserRepository.java # DAO layer to access DB
│ │ │ │
│ │ │ └── service/
│ │ │ ├── UserService.java # Register/save users
│ │ │ └── MyUserDetailService.java # Implements UserDetailsService
│ │ │
│ │ └── resources/
│ │ ├── application.properties # DB and Spring Security config
│ │ └── data.sql (optional) # Seed initial users/roles
│ │
│ └── test/
│ └── java/... # Unit / integration tests (optional)
│
└── pom.xml (or build.gradle)
