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
    f.appendChild(new_table);
}