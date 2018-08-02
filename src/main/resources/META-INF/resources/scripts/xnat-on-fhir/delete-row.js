function deleteRow(element, baseFormLabel) {
    // Removes an element from the document
    while (element.className !== baseFormLabel) {
        element = element.parentNode;
    }

    element.parentNode.removeChild(element);
}