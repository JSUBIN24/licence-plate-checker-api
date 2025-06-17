### LicensePlateChecker

The LicensePlateChecker is a simple program that checks if a license plate is valid, according to a specification.
License plates in this program follow a simplified version of the German system and consist of three parts: 
a town code, a sequence of letters and a sequence of digits.

To be valid, the following conditions have to be fulfilled:
- the town code has to be a valid town code, according to the specification
- the letter sequence has at least the minimum length specified
- the digit sequence has at least the minimum length specified
- the total length of all the parts of the license plate is exactly the total length specified


## How to Run

### Prerequisites

- Java 21 installed and available in `PATH`
- Maven installed

### Compile

```bash
mvn clean compile
java -cp target/classes com.top desk.LicensePlateCheckerMain


Requirement Fulfilled:

The implementation follows the provided contract strictly. All edge cases from the test suite are handled, null-safety is ensured, and validation is regex-driven for clarity and correctness. Assumed letter sequences must be uppercase A–Z based on test behavior. (German Standard number plate accepts only capital letters).

Improvement:

If we have a chance to allow the existing class, I can improvise the invalid Number plate error reason that would support Clearer logging and UI/UX support.

Ex: 
Invalid town code: not in the allowed list.
Letter sequence must be at least X characters.
Digit sequence must contain only numbers.
The total plate length does not match the specification.
