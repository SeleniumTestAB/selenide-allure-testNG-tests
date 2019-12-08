package com.demo.project.documentation;

import static j2html.TagCreator.*;

public class EmployeeDocumentation {

    private String addNewEmployeeDocumentation() {
        return html(body(
                h4(b("Test aim")),
                p("Checking if user as business admin can add new employee"),
                p("In order to do that, the user needs to do couple of things"),
                ol(
                        li("Go to employee list and click on add new employee button"),
                        li("Next fill up the form in the modal and proceed to the new employee wizard"),
                        li("Complete the \"Personal Details\" stage and proceed to the next one"),
                        li("Complete the \"Job\" stage and click on save button")
                ),
                h4(b("Expected Result")),
                p("User is taken to new employee profile page that contains correct data provided during wizard")
        )).render();
    }
}
