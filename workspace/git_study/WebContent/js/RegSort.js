/*
 *
 * tableSort - Client-side table sorting JavaScript
 *
 * Copyright (c) 2007 Shigeki Harada ( http://www.kttnet.co.jp/~harashi/ )
 * GPL licenses.
 * http://www.opensource.org/licenses/gpl-license.php
 *
 */

/** テキスト取得用関数 **/
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

/** 数値取得用関数 **/
function getNum(num){
  if( num.match(/^(\-?((\d{1,3}(,\d\d\d)+)|\d+)(\.\d+)?)(.*)$/i) ){
    nn = RegExp.$1;
    nv = RegExp.$6;
    if(nn == ''){
      nn = '0';
    }
    return(new Array(nn,nv));
  }else{
    return(new Array('0',num));
  }
}

/** 数値でのソート用比較関数 **/
var nsort = function(a,b){
  aa=getNum(a);
  ba=getNum(b);
  a = Number(aa[0].replace(/,/g,''));
  b = Number(ba[0].replace(/,/g,''));
  if( a == b ){
    if( aa[1] == ba[1] ){
      return 0;
    }else if( aa[1] > ba[1] ){
      return 1;
    }else{
      return -1;
    }
  }else if( a > b ){
    return 1;
  }else{
    return -1;
  }
}

/*** メイン処理 ***/
var rev = new Array(); //反転用フラグ
var old_obj = new Array();
function tableSort(bobj,num,sfunc,sank1,sank2){
  
  //tbodyオブジェクトを取得
  //parentNodeが<tr>そのparentNodeが<tbody>
  var btbody = bobj.parentNode.parentNode;
  //alert("btbody : " + typeof(btbody) + "," + btbody.tagName);
  var btid = btbody.id;
  // tbodyにIDがない場合はテーブルのIDを取得
  if( btid == '' ){
    btbody.id = btbody.parentNode.id;
    btid = btbody.id;
  }
  
  //三角をオブジェクトを設定
  if( bobj.sank1 == undefined ){
    bobj.sank1 = document.createTextNode((sank1)?sank1:'△');
    bobj.sank2 = document.createTextNode((sank2)?sank2:'▽');
  }
  
  //反転用のフラグの初期化
  if(rev[btid] == undefined ){
    rev[btid] = Object();
    rev[btid].n = -1;
  }
  
  //反転用のフラグと三角の追加・削除
  if(rev[btid].n == num){
    //同じセルをクリック
    rev[btid].f = !rev[btid].f;
    //三角を反転させる
    if( rev[btid].f ){
      bobj.replaceChild(bobj.sank2,bobj.sank1);
    }else{
      bobj.replaceChild(bobj.sank1,bobj.sank2);
    }
  }else{
    //違うセルをクリック
    //三角を追加
    bobj.appendChild(bobj.sank1);
    //前のセルから△を消す
    if( old_obj[btid] != undefined ){
      if( rev[btid].f ){
        old_obj[btid].removeChild(old_obj[btid].sank2);
      }else{
        old_obj[btid].removeChild(old_obj[btid].sank1);
      }
    }
    rev[btid].n = num;
    rev[btid].f = false;
  }
  old_obj[btid] = bobj;
  
  
  // ソート用の配列初期化
  var xbox = new Array();
  var rows = btbody.rows;
  var rows_num = rows.length - 2;
  
  // ソート対象の値 と 行オブジェクトを取得
  for(i=0;i<rows_num;i++){
    xbox[i] = Object(getStr(rows[i+2].cells[num]));
    xbox[i].row = rows[i+2];
  }
  
  //ソート実行
  if( typeof(sfunc) == 'function' ){
    //関数定義あり
    xbox.sort(sfunc);
  }else{
    //関数定義なし(文字列としてソート)
    xbox.sort(function (a,b){
      if( a == b ){
        return 0;
      }else if( a > b ){
        return 1;
      }else{
        return -1;
       }
    });
  }
  // 反転フラグチェック
  if( rev[btid].f ){
    xbox.reverse();
  }
  //結果をテーブルに反映
  for(i=0;i<rows_num;i++){
    btbody.appendChild(xbox[i].row);
  }
}
