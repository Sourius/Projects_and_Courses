# -*- coding: utf-8 -*-
# error handling
def error_handler():
    try:
        num = int(input("Enter a number: "));
        print("{} was entered".format(num));
    except:
        print("{} is not a valid number!".format(num));
    finally:
        print("Attempted input!");

def read_correct_number():
    while(True):
        try:
            num = int(input("Enter a number: "));
            break;
        except:
            print("{} is not a valid number!".format(num));
        finally:
            print("Attempted input!");
    print("{} was entered".format(num));
    
# file operations
def read_file():
    f = open("newFile.txt","r");
    print(f.readline())
    text = f.read();
    f.close();
    print(text);

def write_file():
    f = open("newFile.txt","w");
    f.write("Hello\n");
    f.write("Welcome to python!\n");
    f.write("You have succesfully readen from file.\n");
    f.close();
 
def write_file_line_by_line():
    lines = ["Hello\n", "Welcome to python!\n", 
             "You are writing multiple lines in a file.\n"]
    f = open("newFile.txt","w");
    f.writelines(lines);
    f.close();

def read_file_line_by_line():
    f = open("newFile.txt","r");
    lines = f.readlines();     
    f.close();
    for line in lines:
        print(line.strip());

def read_file_line_by_line2():
    with open("newFile.txt","r") as f:
        for line in f:
            print(line.strip());
    f.close();

