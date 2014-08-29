function getStr(node){
  var str = '';
  var cn = node.childNodes;
  if(cn){
    for(var i=0;i<cn.length;i++){
      cnv = cn[i].nodeValue;
      if( typeof(cnv) == "string" ){
        str += cnv;
      }else{
        str += getStr(cn[i]);
      }
    }
  }
  return str;
}

var xbox = null;
var row;
var rows_num;
var old_btbody;

function tableFilter(bobj){
	//入力された情報を取得
	var inVal = bobj.parentNode.parentNode.childNodes[0].childNodes[0].value;
	var btbody;
	
	if (xbox== null) {
		xbox = new Array();
		btbody = bobj.parentNode.parentNode.parentNode;

		// 最初のTBLの情報を取得する用
		rows = btbody.rows;
		rows_num = rows.length - 2;
		
		// 最初のTBLの情報を取得
		for(i=0;i<rows_num;i++){
			xbox[i] = Object(getStr(rows[i+2].cells[0]));
			xbox[i].row = rows[i+2];
		}
		old_btbody = btbody;
	} else {
		btbody = old_btbody;
	}


	for(i=0;i<rows_num;i++){
		if (xbox[i].match(inVal)!=null){
		    btbody.appendChild(xbox[i].row);
		} else {
			btbody.removeChild(xbox[i].row);
		}
	}
}