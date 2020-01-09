var id = 1; // 가격 목록에서 tr을 분류하는데 쓸 새로운 값

function skeleton_click(s) {

    var tbody_area = document.getElementById('tbody-purchaseList'); // 가격 목록의 tbody 태그를 반환
    var classification = document.getElementById('classification'+s).textContent; // 선택한 분류 열 text 가져옴
    var item = document.getElementById('item'+s).textContent; // 선택한 아이템 열 text 가져옴
    var standard = document.getElementById('standard'+s).textContent; // 선택한 규격 열 text 가져옴
    var price = document.getElementById('price'+s).textContent; // 선택한 가격 열 text 가져옴


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

    var td_classification_att2 = document.createAttribute('colspan');
    td_classification_att2.value = "2";

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

    var tr_delete = document.createElement('button');
    tr_delete.textContent = "삭제";

    var tr_delete_att = document.createAttribute('class');
    tr_delete_att.value = "btn btn-outline-secondary btn-sm";

    tr_delete.setAttributeNode(tr_delete_att);

    td_price.appendChild(tr_delete);


    // 만든 td(열) tr(행)에 자식으로 넣어줌
    tr_area.appendChild(td_classification);
    tr_area.appendChild(td_item);
    tr_area.appendChild(td_standard);
    tr_area.appendChild(td_count);
    tr_area.appendChild(td_price);

    // 완성된 행 tbody 자식으로 넣어줌
    tbody_area.appendChild(tr_area);
    id++;

}