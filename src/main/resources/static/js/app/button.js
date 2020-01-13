var id = 1; // 가격 목록에서 tr을 분류하는데 쓸 새로운 값
var tbody_area = document.getElementById('tbody-purchaseList'); // 가격 목록의 tbody 태그를 반환

// 좌측에 있는 목록에서 선택할 때 우측 구매목록에 뜨게 하는 함수
// 골조 선택시
function skeleton_click(s) {
    var classification = document.getElementById('td-classification'+s).textContent; // 선택한 분류 열 text 가져옴
    var item = document.getElementById('td-item'+s).textContent; // 선택한 아이템 열 text 가져옴
    var standard = document.getElementById('td-standard'+s).textContent; // 선택한 규격 열 text 가져옴
    var price = document.getElementById('td-price'+s).textContent; // 선택한 가격 열 text 가져옴


    // tr(행) 태그 만들기
    var tr_area = document.createElement('tr');

    var tr_area_att = document.createAttribute('id');
    tr_area_att.value="purchaseList_skeleton"+id;

    tr_area.setAttributeNode(tr_area_att);


    // 분류td(열) 태그 만들기
    var td_classification = document.createElement('td');
    td_classification.textContent = classification;

    var td_classification_att = document.createAttribute('class');
    td_classification_att.value = "firstColumn";

    // material_click()과 차이점
    var td_classification_att2 = document.createAttribute('colspan');
    td_classification_att2.value = "2";
    //

    td_classification.setAttributeNode(td_classification_att);
    td_classification.setAttributeNode(td_classification_att2);


    // 아이템td 태그 만들기
    var td_item = document.createElement('td');
    td_item.textContent = item;


    // 규격td 태그 만들기
    var td_standard = document.createElement('td');
    td_standard.textContent = standard;


    // 갯수td 태그 만들기, select, option 구조
    var td_count = document.createElement('td');
    var select_option = document.createElement('select');
    var select_option_att = document.createAttribute('class');
    select_option_att.value = "form-control";
    select_option.setAttributeNode(select_option_att);

    for(var i = 1; i<100; i++){
        var option_count = document.createElement('option');
        option_count.text = i;
        select_option.appendChild(option_count);
    }

    td_count.appendChild(select_option);


    // 가격td 태그 만들기
    var td_price = document.createElement('td');
    td_price.textContent = price;

    var td_price_att = document.createAttribute('class');
    td_price_att.value = "purchaseList_price";

    td_price.setAttributeNode(td_price_att);

    // 삭제 버튼 만들기
    var btn_delete = document.createElement('button');
    btn_delete.textContent = "삭제";

    var btn_delete_att = document.createAttribute('class');
    btn_delete_att.value = "btn btn-outline-secondary btn-sm";
    var btn_delete_att2 = document.createAttribute('onclick');
    btn_delete_att2.value = "delete_skeleton("+id+")";

    btn_delete.setAttributeNode(btn_delete_att);
    btn_delete.setAttributeNode(btn_delete_att2);

    td_price.appendChild(btn_delete);


    // 만든 td(열) tr(행)에 자식으로 넣어줌
    tr_area.appendChild(td_classification);
    tr_area.appendChild(td_item);
    tr_area.appendChild(td_standard);
    tr_area.appendChild(td_count);
    tr_area.appendChild(td_price);

    // 완성된 행 tbody 자식으로 넣어줌
    tbody_area.appendChild(tr_area);
    id++;
    skeletonNext();
}

// 골조 외 품목 선택시
function material_click(s) {

    var classification = document.getElementById('td-classification'+s).textContent; // 선택한 분류 열 text 가져옴
    var item = document.getElementById('td-item'+s).textContent; // 선택한 아이템 열 text 가져옴
    var standard = document.getElementById('td-standard'+s).textContent; // 선택한 규격 열 text 가져옴
    var price = document.getElementById('td-price'+s).textContent; // 선택한 가격 열 text 가져옴

    // tr(행) 태그 만들기
    var tr_area = document.createElement('tr');

    var tr_area_att = document.createAttribute('id');
    tr_area_att.value="purchaseList_material"+id;

    tr_area.setAttributeNode(tr_area_att);

    // 빈td(열) 태그 만들기
    var td_none = document.createElement('td');
    var td_none_att = document.createAttribute('class');
    td_none_att.value = "firstColumn";
    td_none.setAttributeNode(td_none_att);

    // 분류td(열) 태그 만들기
    var td_classification = document.createElement('td');
    td_classification.textContent = classification;


    // 아이템td 태그 만들기
    var td_item = document.createElement('td');
    td_item.textContent = item;


    // 규격td 태그 만들기
    var td_standard = document.createElement('td');
    td_standard.textContent = standard;


    // 갯수td 태그 만들기, select, option 구조
    var td_count = document.createElement('td');
    var select_option = document.createElement('select');
    var select_option_att = document.createAttribute('class');
    select_option_att.value = "form-control";
    select_option.setAttributeNode(select_option_att);

    for(var i = 1; i<100; i++){
        var option_count = document.createElement('option');
        option_count.text = i;
        select_option.appendChild(option_count);
    }

    td_count.appendChild(select_option);


    // 가격td 태그 만들기
    var td_price = document.createElement('td');
    td_price.textContent = price;

    var td_price_att = document.createAttribute('class');
    td_price_att.value = "purchaseList_price";

    td_price.setAttributeNode(td_price_att);

    // 삭제 버튼 만들기
    var btn_delete = document.createElement('button');
    btn_delete.textContent = "삭제";

    var btn_delete_att = document.createAttribute('class');
    btn_delete_att.value = "btn btn-outline-secondary btn-sm";
    var btn_delete_att2 = document.createAttribute('onclick');
    btn_delete_att2.value = "delete_material("+id+")";

    btn_delete.setAttributeNode(btn_delete_att);
    btn_delete.setAttributeNode(btn_delete_att2);

    td_price.appendChild(btn_delete);


    // 만든 td(열) tr(행)에 자식으로 넣어줌
    tr_area.appendChild(td_none);
    tr_area.appendChild(td_classification);
    tr_area.appendChild(td_item);
    tr_area.appendChild(td_standard);
    tr_area.appendChild(td_count);
    tr_area.appendChild(td_price);

    // 완성된 행 tbody 자식으로 넣어줌
    tbody_area.appendChild(tr_area);
    id++;
}

// 삭제 버튼 클릭시 구매 목록에서 삭제
// 골조
function delete_skeleton(id) {
    $('#purchaseList_skeleton'+id).remove();
    alert("구매목록에서 삭제되었습니다.");
    this.id--;
};

// 골조 외 품목
function delete_material(id) {
    $('#purchaseList_material'+id).remove();
    alert("구매목록에서 삭제되었습니다.");
    this.id--;
};

// 골조 외 품목 선택시 구매목록에 추가하고 다음 목록으로 넘김
function insulation_click(s) {
    material_click(s);
    insulationNext();
}

function exterior_click(s) {
    material_click(s);
    exteriorNext();
}

function interior_click(s) {
    material_click(s);
    interiorNext();
}

function window_click(s) {
    material_click(s);
    windowNext();
}

// 선택 버튼 클릭 시 현재 목록 숨기고 다음 목록 보이게 함
function skeletonNext() {
    $('#tbodySkeleton').hide();
    $('#tbodyInsulation').show();
}

function insulationNext() {
    $('#tbodyInsulation').hide();
    $('#tbodyExterior').show();
}

function exteriorNext() {
    $('#tbodyExterior').hide();
    $('#tbodyInterior').show();
}

function interiorNext() {
    $('#tbodyInterior').hide();
    $('#tbodyWindow').show();
}

function windowNext() {
    $('#tbodyWindow').hide();
    $('#tbodySkeleton').show();
    alert("선택이 완료되었습니다.")
}