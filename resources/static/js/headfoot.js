$("nav > ul > li").mouseenter(function(){
    $(this).children(".submenu").stop().slideDown(400);
  });
  $("nav > ul > li").mouseleave(function(){
    $(this).children(".submenu").stop().slideUp(100);
  });