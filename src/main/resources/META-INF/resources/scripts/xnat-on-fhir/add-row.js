function findForm(element) {
    var result = element;
    while (result && result.tagName.toLowerCase() !== "form") {
        result = result.parentNode;
    }
    return result;
}

function fixInputNames(fields, counter) {
    for (var i = 0; i < fields.length; i++) {
        var e = fields[i];
        e.id = e.name.replace('__COUNTER__', counter)
        e.name = e.id;
    }
}

function findBaseFormElement(element, label) {
    // First we search for a div with class "form_block"
    var e = element;
    while (e.className !== "form_block") {
        e = e.parentNode;
    }

    // Afterwards we search a child with the given label
    for (var index = 0; index < e.children.length; index++) {
        var child = e.children[index];
        if (child.dataset.label === label) {
            return child;
        }
    }

    return undefined;
}

function addRow(element, baseFormLabel) {
    var baseFormElement = findBaseFormElement(element, baseFormLabel);
    var f = findForm(baseFormElement);

    var existing = document.getElementsByClassName(baseFormLabel);
    var counter = existing.length;

    var newForm = baseFormElement.cloneNode(true);
    newForm.className = baseFormLabel;

    fixInputNames(newForm.getElementsByTagName("input"), counter);
    fixInputNames(newForm.getElementsByTagName("select"), counter);
    fixInputNames(newForm.getElementsByTagName("textarea"), counter);

    newForm.id = baseFormLabel + counter;
    newForm.style.display = "block";
    baseFormElement.parentNode.appendChild(newForm);
}