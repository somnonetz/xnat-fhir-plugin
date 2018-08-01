function deleteRow(element) {
    // Removes an element from the document
    while (element.className !== "identifierTable") {
        element = element.parentNode;
    }

    element.parentNode.removeChild(element);
}

function deleteNameRow(element) {
    // Removes an element from the document
    while (element.className !== "nameTable") {
        element = element.parentNode;
    }

    element.parentNode.removeChild(element);
}

function deleteContactRow(element) {
    // Removes an element from the document
    while (element.className !== "telecomTable") {
        element = element.parentNode;
    }

    element.parentNode.removeChild(element);
}

function deleteAddressRow(element) {
    // Removes an element from the document
    while (element.className !== "addressTable") {
        element = element.parentNode;
    }

    element.parentNode.removeChild(element);
}

function deletePhoto(element) {
    // Removes an element from the document
    while (element.className !== "photoTable") {
        element = element.parentNode;
    }

    element.parentNode.removeChild(element);
}