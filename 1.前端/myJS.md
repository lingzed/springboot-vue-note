# 复选框



## 选择行为

```js
/**
 * @param {Object} allSelectId
 * @param {Object} CheckClass
 * 复选框选择函数，传入头选择框的id，和子选择框的class
 * 头选中，子全选，头不选中，子全不选中，子全选中时，有一个未选中，头不选中
 */
function setupCheckbox(allSelectId, CheckClass) {
    $("#" + allSelectId).click(function () {
        const isChecked = $(this).prop("checked");
        $("." + CheckClass).prop("checked", isChecked);
    });
    $("." + CheckClass).click(function () {
        $("#" + allSelectId).prop("checked", false);
    });
}
```



## 选中的个数

```js
/**
 * 获取复习框选中的长度
 * @param CheckClass
 * @returns {jQuery}
 */
function selectLength(CheckClass) {
    return $("." + CheckClass + ":checked").length;
}
```



## 是否选中复选框

```js
/**
 * @param {Object} CheckClass
 * 传入复习框的class，判断是否有选中，有就返回true，否则返回false
 */
function isSelect(CheckClass) {
    return selectLength(CheckClass) == 0 ? false : true; 
}
```

