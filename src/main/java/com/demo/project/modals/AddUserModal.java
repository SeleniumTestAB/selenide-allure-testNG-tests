package com.demo.project.modals;

import com.demo.project.pages.generic.elements.GenericSelectList;

public class AddUserModal {
    private final GenericSelectList essRoleSelect = new GenericSelectList("essrole_inputfileddiv", "essrole");
    private final GenericSelectList supervisorRoleSelect = new GenericSelectList("supervisorrole_inputfileddiv", "supervisorrole");
    private final GenericSelectList adminRoleSelect = new GenericSelectList("adminrole_inputfileddiv", "adminrole");
    private final GenericSelectList statusSelect = new GenericSelectList("status_inputfileddiv", "status");
}
