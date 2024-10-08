# RestAssured-API-Testing

Welcome to the RestAssured-API-Testing project! This is a sample project designed to demonstrate **BDD (Behavior-Driven Development)** testing framework created using **Cucumber** and **JUnit**. It tests the functionality of an API that allows representatives to create and manage quotes. The framework leverages **RestAssured** for HTTP requests, **Gson** for JSON handling, and follows best practices to ensure modularity and ease of maintenance.

## Features
- **Cucumber Framework Integration**: Create behavior-driven test scenarios using Gherkin syntax.
- **RestAssured Setup**: Seamlessly handle HTTP requests and responses.
- **Java and JUnit**: Utilize Java for test automation and JUnit for executing tests.
- **Modular Structure**: Organize your test code for ease of maintenance and scalability.

## Prerequisites
Before getting started with the Quote API Testing Framework, ensure you have the following prerequisites:

- Java Development Kit (JDK)
- Integrated Development Environment (IDE)
- Maven for dependency management
- Basic understanding of Cucumber and Gherkin syntax
- Familiarity with RESTful API concepts
  
## Setting Up the Project
To set up the project, follow these steps:
 ### 1. Open the Project:
 Use an IDE like IntelliJ IDEA or Eclipse to open the project.

 ### 2. Install Dependencies:
 Run the following Maven commands to install project dependencies:
 
 - `mvn clean install`
 - `mvn dependency:resolve`
 
 This will download and install all required dependencies specified in the pom.xml file, preparing the project for execution.

## Folder Structure

The project is divided into several packages and files under the `src/test/java` directory:

### 1. `core.endpoints`
- **BaseEndpoint**:
  - Contains the logic to make HTTP requests to the API (GET and POST).
  - Utilizes the `callEndpoint()` method to send requests and `JsonHelper` to serialize and deserialize JSON.
  
- **QuoteEndpoint**:
  - Inherits from `BaseEndpoint` and is responsible for interacting with the Quote API endpoints.
  - Includes methods for sending API requests, such as `createQuote()`, `getIsAlive()`, and response parsing using `JsonHelper`.

### 2. `core.library`
- **Constants**:
  - Contains commonly used constants like URLs and HTTP status codes.
  
- **JsonHelper**:
  - Utility class for serializing objects to JSON and deserializing JSON to objects using Gson.
  
- **PropertyLoader**:
  - Singleton class for managing configuration properties (e.g., base URL).
  
- **RequestType**:
  - Enum that defines the request types: GET and POST.

### 3. `core.model.quote`

#### **Body:**
- **QuoteBodyDTO**:
  - Data Transfer Object representing the body of a quote creation request, containing the customer and list of items.
  
- **QuoteBodyItemDTO**:
  - Represents individual quote items, with fields for `item`, `quantity`, `unitaryPrice`, and `discountPercentage`.

#### **Response:**
- **QuoteCreateResponseDTO**:
  - The main response DTO for a quote creation, containing the quote and confirmation message.
  
- **QuoteCreateResponseLineDTO**:
  - Represents individual line items in the quote, including `item`, `quantity`, `unitaryPrice`, `discount`, and `linePrice`.
  
- **QuoteCreateResponseConfirmationDTO**:
  - Contains the confirmation level and message after quote creation.
  
- **QuoteCreateResponseQuoteDTO**:
  - Holds details of the overall quote, including `totalPrice`, `id`, and `status`.

### 4. `hooks`
- **Hooks**:
  - Manages setup and teardown actions before and after all tests (`@BeforeAll`, `@AfterAll`), such as setting the base URL using `PropertyLoader`.

### 5. `steps`
- **QuoteStepDefinitions**:
  - Contains Cucumber step definitions for testing the quote creation feature.
  
- **StepsDataHolder**:
  - A utility class for holding request and response data across different steps during test execution.

### 6. `resources/features`
- **create_quote.feature**:
  - Cucumber feature file for testing the "Create Quote" functionality.
  - Contains scenarios for creating quotes, including both valid and invalid cases (e.g., missing customer name, invalid quantity or price, discount exceeding 100%).

---

## Running the Tests

### `RunCucumberTest` Class

The `RunCucumberTest` class, located in the `src/test/java` directory, is the entry point for executing Cucumber tests. It uses annotations to specify the following:

- **@RunWith(Cucumber.class)**: This annotation indicates that the tests should be run using Cucumber's JUnit integration.
  
- **@CucumberOptions**: This annotation configures the test execution with several important options:
  - `features`: Points to the path where the Cucumber feature files are located.
  - `publish`: When set to `true`, it enables the publication of the test execution report.
  - `plugin`: Specifies the format and location of the report output (e.g., an HTML report generated in the `target` directory).

This class is critical for orchestrating the execution of Cucumber feature files and generating reports for test results.

---
## Test Reports

After running the tests, you can find the test execution reports in the `target` directory. The reports are generated in HTML format, providing a detailed overview of the test results.

![Test Report ](https://github.com/NoushinB/RestAssured-API-Testing/blob/master/src/test/resources/documents/report.png) 

---

## Test Execution Demo
    

[![Watch the RestAssured-API-Testing DEMO](https://github.com/NoushinB/RestAssured-API-Testing/blob/master/src/test/resources/documents/RestAssured_Demo.png?raw=true)](https://youtu.be/FwECd4aUeco)
