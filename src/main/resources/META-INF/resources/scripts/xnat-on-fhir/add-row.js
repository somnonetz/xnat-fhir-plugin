var num_fields = 0;

function addRow() {
    var f = document.forms.patientForm;

    var table = document.getElementById("dataTable");
    var base = table.dataset.base;
    var exitsingTables = document.getElementsByClassName("identifierTable");
    num_fields = exitsingTables.length;

    var new_table = table.cloneNode(true);
    new_table.className = "identifierTable";

    var input_elements = new_table.getElementsByTagName("input");
    var select_elements = new_table.getElementsByTagName("select");
    for (var i = 0; i < input_elements.length; i++) {
        var e = input_elements[i];
        e.id = base + "[" + num_fields + "]/" + e.name;
        e.name = e.id;
    }

    for (var i = 0; i < select_elements.length; i++) {
        var e = select_elements[i];
        e.id = base + "[" + num_fields + "]/" + e.name;
        e.name = e.id;
    }

    new_table.id = "identifierTable" + num_fields;
    new_table.style.display = "block";
    table.parentNode.appendChild(new_table);
}

function addNameRow() {
    var f = document.forms.patientForm;

    var table = document.getElementById("nameTable");
    var base = table.dataset.base;
    var exitsingTables = document.getElementsByClassName("nameTable");
    num_fields = exitsingTables.length;

    var new_table = table.cloneNode(true);
    new_table.className = "nameTable";

    var input_elements = new_table.getElementsByTagName("input");
    var select_elements = new_table.getElementsByTagName("select");
    for (var i = 0; i < input_elements.length; i++) {
        var e = input_elements[i];
        e.id = base + "[" + num_fields + "]/" + e.name;
        e.name = e.id;
    }

    for (var i = 0; i < select_elements.length; i++) {
        var e = select_elements[i];
        e.id = base + "[" + num_fields + "]/" + e.name;
        e.name = e.id;
    }

    new_table.id = "nameTable" + num_fields;
    new_table.style.display = "block";
    table.parentNode.appendChild(new_table);
}

function addContactRow() {
    var f = document.forms.patientForm;

    var table = document.getElementById("telecomTable");
    var base = table.dataset.base;
    var exitsingTables = document.getElementsByClassName("telecomTable");
    num_fields = exitsingTables.length;

    var new_table = table.cloneNode(true);
    new_table.className = "telecomTable";

    var input_elements = new_table.getElementsByTagName("input");
    var select_elements = new_table.getElementsByTagName("select");
    for (var i = 0; i < input_elements.length; i++) {
        var e = input_elements[i];
        e.id = base + "[" + num_fields + "]/" + e.name;
        e.name = e.id;
    }

    for (var i = 0; i < select_elements.length; i++) {
        var e = select_elements[i];
        e.id = base + "[" + num_fields + "]/" + e.name;
        e.name = e.id;
    }

    new_table.id = "telecomTable" + num_fields;
    new_table.style.display = "block";
    table.parentNode.appendChild(new_table);
}

function fix_input_names(base, fields, counter) {
    for (var i = 0; i < fields.length; i++) {
        var e = fields[i];
        e.id = base + "[" + counter + "]/" + e.name;
        e.name = e.id;
    }
}

function addAddressRow() {
    var f = document.forms.patientForm;

    var table = document.getElementById("addressTable");
    var base = table.dataset.base;
    var exitsingTables = document.getElementsByClassName("addressTable");
    num_fields = exitsingTables.length;

    var new_table = table.cloneNode(true);
    new_table.className = "addressTable";

    fix_input_names(base, new_table.getElementsByTagName("input"), num_fields);
    fix_input_names(base, new_table.getElementsByTagName("select"), num_fields);
    fix_input_names(base, new_table.getElementsByTagName("textarea"), num_fields);

    new_table.id = "addressTable" + num_fields;
    new_table.style.display = "block";
    table.parentNode.appendChild(new_table);
}

function addPhoto() {
    var f = document.forms.patientForm;

    var table = document.getElementById("photoTable");
    var base = table.dataset.base;
    var exitsingTables = document.getElementsByClassName("photoTable");
    num_fields = exitsingTables.length;

    var new_table = table.cloneNode(true);
    new_table.className = "photoTable";

    fix_input_names(base, new_table.getElementsByTagName("input"), num_fields);
    fix_input_names(base, new_table.getElementsByTagName("select"), num_fields);
    fix_input_names(base, new_table.getElementsByTagName("textarea"), num_fields);

    new_table.id = "photoTable" + num_fields;
    new_table.style.display = "block";
    table.parentNode.appendChild(new_table);
}