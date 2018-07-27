function deleteRow(element) {
    // Removes an element from the document
    while (element.className !== "identifierTable") {
        element = element.parentNode;
    }

    element.parentNode.removeChild(element);
}