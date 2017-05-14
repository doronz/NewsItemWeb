var drawerEl = document.querySelector('.mdc-persistent-drawer');
var MDCPersistentDrawer = mdc.drawer.MDCPersistentDrawer;
var drawer = new MDCPersistentDrawer(drawerEl);
document.querySelector('.doron-menu').addEventListener('click', function() {
  drawer.open = !drawer.open;
});
drawerEl.addEventListener('MDCPersistentDrawer:open', function() {
  console.log('Received MDCPersistentDrawer:open');
});
drawerEl.addEventListener('MDCPersistentDrawer:close', function() {
  console.log('Received MDCPersistentDrawer:close');
});
  
var forEach = function (array, callback, scope) {
  for (var i = 0; i < array.length; i++) {
    callback.call(scope, i, array[i]); // passes back stuff we need
  }
};

var textFields = document.querySelectorAll('.mdc-textfield');
forEach(textFields, function (index, value) {
  mdc.textfield.MDCTextfield.attachTo(value);
});


mdc.autoInit();