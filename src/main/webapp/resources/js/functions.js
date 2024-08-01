function deleteStudents() {

    const checkedCheckBoxes = document.querySelectorAll('input[name=studentId]:checked');
    if (checkedCheckBoxes.length == 0) {
        alert("����������, �������� ���� �� ������ ��������");
        return;
    }
    let ids = ""; // "1 2 3"

    for (let i = 0; i < checkedCheckBoxes.length; i++) {
        ids = ids + checkedCheckBoxes[i].value + " ";
    }

    document.getElementById("idsForDelete").value = ids;
    document.getElementById("deleteForm").submit();
}

function modifyStudents() {

    const checkedCheckBoxes = document.querySelectorAll('input[name=studentId]:checked');
    if (checkedCheckBoxes.length == 0) {
        alert("����������, �������� ������ ��������");
        return;
    }

    if (checkedCheckBoxes.length > 1) {
        alert("����������, �������� ������ ������ ��������");
        return;
    }

    let id = checkedCheckBoxes[0].value; // "1"

    document.getElementById("idsForModify").value = id;
    document.getElementById("modifyForm").submit();
}

function studentProgress() {

    const checkedCheckBoxes = document.querySelectorAll('input[name=studentId]:checked');
    if (checkedCheckBoxes.length == 0) {
        alert("����������, �������� ������ ��������");
        return;
    }

    if (checkedCheckBoxes.length > 1) {
        alert("����������, �������� ������ ������ ��������");
        return;
    }

    let id = checkedCheckBoxes[0].value; // "1"

    document.getElementById("idForProgress").value = id;
    document.getElementById("progressForm").submit();
}