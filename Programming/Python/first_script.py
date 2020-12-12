def first_script():
    print('Congratulations on running this script!!')

def print_snakes():
    how_many_snakes = 1
    snake_string = """
    Welcome to Python3!
    
                 ____
                / . .\\
                \  ---<
                 \  /
       __________/ /
    -=:___________/

    <3, Juno
    """

    print(snake_string * how_many_snakes)


def student_reminder():
    names =  input("Enter names separated by commas: ").title().split(",");
    assignments = list(input("Enter assignments count seperated by commas: ").title().split(","));
    grades = list(input("Enter grades seperated by commas: ").title().split(","));
    
    # message string to be used for each student
    # HINT: use .format() with this string in your for loop
    print();
    message = "Hi {},\n\nThis is a reminder that you have {} assignments left to submit before you can graduate. You're current grade is {} and can increase to {} if you submit all assignments before the due date.\n\n"
    
    # write a for loop that iterates through each set of names, assignments, and grades to print each student's message
    for name,assignment,grade in zip(names,assignments,grades):
        potencial_grade = int(grade) + int(assignment) * 2;
        print(message.format(name, assignment, grade, potencial_grade));

