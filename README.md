# DataCommunicationProject

## Description

Data Conversion Tool is a web application built using Spring Boot that performs various data communication operations. This tool allows users to calculate Hamming Distance, perform Parity Checks, and handle Bit Stuffing and Bit Destuffing operations.

## Features

- **Hamming Distance Calculation**: Computes the Hamming distance between two input strings.
- **Parity Check**: Determines if the input string has even or odd parity.
- **Bit Stuffing**: Adds a '0' after five consecutive '1's in the input string.
- **Bit Destuffing**: Removes the '0' added by bit stuffing from the input string.

## Technologies Used

- **Spring Boot**: Backend framework
- **Thymeleaf**: Template engine for rendering HTML
- **Java**: Programming language
- **HTML & CSS**: Frontend styling

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/dataconversiontool.git
    ```
2. Navigate to the project directory:
    ```bash
    cd dataconversiontool
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage

1. Open your browser and navigate to `http://localhost:8080/data`.
2. Select an operation from the dropdown menu.
3. Enter the required inputs.
4. Click the "Calculate" button to see the result.

## Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m 'Add feature'`.
4. Push to the branch: `git push origin feature-name`.
5. Open a pull request.


## Contact

For any inquiries or feedback, please contact **email:ahmedmdnayeem05@gmail.com**.
