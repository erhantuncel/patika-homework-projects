# Patika Clone

A desktop app that is cloning patika.dev website developed with Java Swing.

## Technologies
- Language: Java Swing - JDBC
- Database: Postgresql

## Requirements

### Operator Panel

- Operators should be able to list, add, update and remove users(operator, educator, student).
- Operators should be able to search users by name, username and user type.
- Operators should be able to list, add, update and remove patikas.
- Operators should be able to list add, update and remove courses.
- Operators should be able to list add, update and remove quizes.

### Educator Panel

- Educators should be able to list tutorials those are appointed by operator. They are not allowed to edit or delete courses. They are not allowed to see courses those are appointed to another educators.
- The tasks of educators will be to add content to the courses.
- Educators should be able to list, add, and edit their contents.
- Contents of course properties are:
  - Title
  - Description
  - Youtebe link
  - Quize questions
  - Course
- Quize questions should be added from educator panel and when adding question, which content it belongs to should be selected.
- On content listing panel, it should be able to filter by course and content title.

### Student Panel

- When students login to the system, should be able to access courses via patikas.
- Students should be able to list patikas.
- Students should register a course via patikas.
- Students should be able to access and view contents of courses those registered before.
- Students should be able to vote and comment contents belongs to course.
- Students should be able to solve course quizes.

### Login Panel

- On login panel, students should be able to register if they don't have account.
- Only students should be able to register.

- Developer should add the operators, and only operators should be able to add the educators.