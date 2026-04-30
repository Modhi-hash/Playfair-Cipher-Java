# Playfair-Cipher-Java

## Playfair Cipher Encryption & Decryption System 

A professional Java-based implementation of the classical Playfair Cipher algorithm, featuring a modern Graphical User Interface (GUI) built with Swing. This project was developed as part of the Computer Security (CS 320) course at King Faisal University.

## Features
* **Encryption & Decryption:** Full implementation of the Playfair algorithm rules.
* **Automated Text Preprocessing:** Handles spaces, converts to uppercase, replaces 'J' with 'I', and manages duplicate letters by inserting 'X'.
* **Modern GUI:** A user-friendly interface with a dark purple theme, custom-styled buttons, and hover effects.
* **Input Validation:** Ensures all fields are filled before processing to prevent runtime errors.

## Technologies Used
* **Language:** Java.
* **GUI Framework:** Java Swing & AWT.
* **Tools:** GitHub for version control.

## How it Works
The system follows the standard Playfair Cipher steps:
1. Key Matrix Generation: Creates a $5 \times 5$ matrix using a unique keyword followed by the remaining alphabet.
2. Rule Application:
   * Same Row: Shift right (encrypt) or left (decrypt).
   * Same Column: Shift down (encrypt) or up (decrypt).
   * Rectangle (Diagonal): Swap columns while staying in the same rows.
   

## Preview


## Developer

Modhi Bandar Alshammri - Lead Developer & UI Designer

## Acknowledgments

Special thanks to my project teammates: Munira Khalid Almulhim and Dana Shaynan Aldossry.
