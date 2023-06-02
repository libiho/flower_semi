/*
* ---------------------------------------------------------------------------
* jQuery Version
* ---------------------------------------------------------------------------
*/

$(function () {

})

// 주소찾기
$(function () {
    // 주소 찾기
    $(".non-address-find-button").click(function () {
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function (data) { //선택시 입력값 세팅
                $(".non-address-detail").html(data.address); // 주소 넣기
                $(".non-address-input").val(data.zonecode); // 우편번호 넣기
                $(".non-address-detail-input").focus(); //상세입력 포커싱
                console.log(data.zonecode);
            }
        }).open();
    })

});

// 헤더 픽스
let $defaultHeader = $('header'),
    $defaultsearch = $('#input-panel'),
    $defaultrank = $('.rank-list-panel');

$(window).scroll(function () {
    console.log($(this).scrollTop())
    if ($(this).scrollTop() > 120) {
        $defaultHeader.addClass('fixedheader');
        $defaultsearch.removeClass('default-input-panel');
        $defaultsearch.addClass('fixed-input-panel');

    } else {
        $defaultHeader.removeClass('fixedheader');
        $defaultsearch.removeClass('fixed-input-panel');
        $defaultsearch.addClass('default-input-panel');

    }

    // 실시간 검색어 픽스
    if ($(this).scrollTop() > 120) {
        $defaultrank.removeClass('default-rank-list-panel');
        $defaultrank.addClass('fixed-rank-list-panel');
    } else {
        $defaultrank.addClass('default-rank-list-panel');
        $defaultrank.removeClass('fixed-rank-list-panel');
    }

    // 결제 정보 패널 픽스
    if ($(this).scrollTop() > 120) {
        $(".cart-side-content").css("position", "fixed");
        $(".cart-side-content").css("top", "20px");
    } else {
        $(".cart-side-content").css("position", "absolute");
        $(".cart-side-content").css("top", "0px");

    }

    if ($(this).scrollTop() > 770) {
        $(".pd-tabs").addClass("fixed-top");
        $(".pd-tabs").css("marginLeft", "425px");
        $(".pd-tabs").css("marginRight", "425px");
    } else {
        $(".pd-tabs").removeClass("fixed-top");
        $(".pd-tabs").css("marginLeft", "0");
        $(".pd-tabs").css("marginRight", "0");
    }

    $("pd-mv")

});


// 로고 전환
function switchImages(newPath) {
    let $logo = $("#logo");
    $logo.fadeOut(0, function () {
        $logo.attr("src", newPath); // 이미지 소스 요소 가져오기
        $logo.fadeIn(0);
    }); // jquery fadeout 
}

// 종류별 호버시
let $type = $(".header-nav-hidden-panel");
$(function () {
    $('.type-li, .header-nav-hidden-panel').mouseover(function () {
        $type.css('display', 'block');
        $('.type-span').css('color', 'rgb(248, 178, 188)');
    })

    $('.type-li, .header-nav-hidden-panel').mouseout(function () {
        $type.css('display', 'none');
        $('.type-span').css('color', 'black');
    })

    $(".header-type-panel li").mouseover(function () {
        $(this).find("span").css("color", "rgb(248, 178, 188)");
    })

    $(".header-type-panel li").mouseout(function () {
        $(this).find("span").css("color", "");
    })
})

// 실시간 검색어
$(function ($) {
    let ticker = function () {
        timer = setTimeout(function () {
            $('.rank-ul li:first').animate({ marginTop: '-55px' }, 600, function () {
                $(this).detach().appendTo('ul.rank-ul').removeAttr('style');
            });
            ticker();
        }, 2500);
    };

    //마우스를 올렸을 때 기능 정지
    let tickerover = function () {
        $('.rank-ul').mouseover(function () {
            clearTimeout(timer);
        });
        $('.rank-ul').mouseout(function () {
            ticker();
        });
    };
    tickerover();
    // 4 끝
    ticker();

});

// 고객센터 탭 전환(공지사항, 자주하는 질문, 1:1문의)
$(function () {
    let tabAnchor = $(".tabs-nav a"),
        tabPanel = $('.tabs-panel');

    // 링크 클릭시
    tabAnchor.click(function (e) {
        e.preventDefault(); // 링크 기본속성 막기

        tabAnchor.removeClass("active");
        $(this).addClass("active");

        tabPanel.hide(); // display:none;

        let $target = $(this).attr('href');
        console.log($target);
        $($target).show();


    });
});

// 실시간 검색어 열고 닫기
$(function () {
    let openRank = $(".downButton"),
        closeRank = $(".rank-close-btn"),
        rankPanel = $(".rank-list-panel");

    // 열기
    openRank.click(function () {
        if (rankPanel.css("display") == "none") {
            rankPanel.show();
            openRank.css("transform", "rotate(180deg)");
        } else {
            rankPanel.hide();
            openRank.css("transform", "rotate(360deg)");
        }
    })

    // 닫기
    closeRank.click(function () {
        rankPanel.hide();
        openRank.css("transform", "rotate(360deg)");
    })
});




// 최근 검색어
$(function () {
    let toDoForm = document.querySelector("#todo-form"); // 메인 input form
    let toDoInput = toDoForm.querySelector("input"); // 메인 검색창
    let toDoList = document.querySelector(".real-time-list>ul"); // ul
    let allDelete = document.querySelector(".real-time-allDelete"); // 전체 삭제 버튼

    const TODOS_KEY = "todos"; // 최근 검색어 키값

    let toDos = new Array(); // 최근 검색어 배열

    function saveToDos(tts) { //item을 localStorage에 저장
        typeof (Storage) !== 'undefined' && localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
    }

    function allDeleteToDo() { //전체 item을 삭제
        localStorage.clear(toDos);
        toDoList.innerText = '';
    };

    function deleteToDo(e) { //각각의 item을 삭제
        const li = e.target.parentElement;
        li.remove();
        toDos = toDos.filter((toDo) => toDo.id !== parseInt(li.id));
        saveToDos();
    };

    function paintToDo(newTodo) { //화면에 출력
        const { id, text } = newTodo;
        const item = document.createElement("li");
        const img = document.createElement("img");
        const atag = document.createElement("a");
        atag.className = 'keywords';
        img.src = '${pageContext.request.contextPath}/resources/image/smallSearch.png';
        const button = document.createElement("button");
        button.className = "real-time-delete";

        item.id = id;
        atag.innerText = text;
        button.addEventListener("click", deleteToDo);
        allDelete.addEventListener("click", allDeleteToDo);
        item.appendChild(img);
        item.appendChild(atag);
        item.appendChild(button);
        toDoList.prepend(item);
        console.log(toDos.length);
        newTodo !== null && allDelete.classList.remove('off');
    };


    function handleToDoSubmit(event) { //form 전송
        //const now = new Date();
        event.preventDefault();

        // if ($(toDoList).children().length > 4) {
        //     $(toDoList).children().last().remove();
        // }

        for (let i in toDos) {
            if (Date.now() > toDos[i].id) {
                toDos.splice(i, 1);
                toDos.pop();
            }
        }

        const newTodoItem = toDoInput.value;
        toDoInput.value = '';
        const newTodoObj = {
            id: Date.now() + 7000,
            //id: now.getTime() + 5000,
            text: newTodoItem
        };

        toDos.push(newTodoObj);
        paintToDo(newTodoObj);
        saveToDos();
    };

    toDoForm.addEventListener('submit', handleToDoSubmit);

    const savedToDos = JSON.parse(localStorage.getItem(TODOS_KEY));

    if (savedToDos !== null) {
        toDos = savedToDos //전에 있던 items들을 계속 가지고 있도록 합니다. 
        savedToDos.forEach(paintToDo);
        // 여기서수정
    }
})


$(function () {
    let mainSearch = $("#main-search"), // 입력창 input
        realTimePanel = $(".real-time-panel"),
        header = $("header");
    //allDelete = $(".real-time-allDelete"); // 전체 삭제

    mainSearch.click(function () {
        if (realTimePanel.css("display") == "none" && header.hasClass("fixedheader") == false) {
            realTimePanel.show();
        } else {
            realTimePanel.hide();
        }
    })

})

$(function () {
    //스크롤 이동시 작동 scroll
    $(window).scroll(function () {
        if ($(this).scrollTop() > 500) {
            // 이펙트 효과 함수임둥.
            $("#btn_go_top").fadeIn();
        } else {
            $("#btn_go_top").fadeOut();
        }
    })

    $("#btn_go_top").click(function () {
        // animate를 이용해 맨위로 이동하도록 설정
        $('html, body').animate({
            scrollTop: 0
        }, -500);
        //return false;  
    })
})


// 고객센터 아코디언 (동적으로 생성된 태그에 이벤트 주기)
$(document).on("click", ".row-li", function () {
    const $li = $(this).next();

    if ($li.css("display") == "none") {
        $(this).siblings(".hidden-li").slideUp();

        $li.slideDown(200);
    } else {
        $li.slideUp(200);
    }
})



// 상품 상세 페이지
$(function () {
    $('.pd-btn').mouseover(function () {
        $(this).css("border", "2px solid pink");
        let $tmp = $(this).attr("src");
        $('.pd-main').attr("src", $tmp);
    })

    $('.pd-btn').mouseout(function () {
        $(this).css("border", "none");
    })

    $('.pd-mv-btn').click(function () {
        $(".pd-mv-btn").css("color", "black");
        $(this).css("color", "pink");
    })

    // 상세페이지 위치 이동
    $(".pd1").click(function () {
        var height = $(".t1").offset();

        $("html, body").animate({ scrollTop: height.top }, -0);
    })

    $(".pd2").click(function () {
        var height = $(".t2").offset();

        $("html, body").animate({ scrollTop: height.top }, -0);
    })

    $(".pd3").click(function () {
        var height = $(".t3").offset();

        $("html, body").animate({ scrollTop: height.top }, -0);
    })

    $(".pd4").click(function () {
        var height = $(".t4").offset();

        $("html, body").animate({ scrollTop: height.top }, -0);
    })



    $(".call-tr").click(function(){
        let $tr1 = $(this).next(); 
        let $tr2 = $(this).next().next();
        let $tr3 = $(this).next().next().next();

        if ($tr1.css("display") == "none" && $tr2.css("display") == "none" && $tr3.css("display") == "none"){
            $tr1.show();
            $tr2.show();
            $tr3.show();
        } else {
            $tr1.hide();
            $tr2.hide();
            $tr3.hide();
        }
        
    })
    
	
})




//--------------------------챗 사이드바 -------------------------

    // 사이드바 토글 버튼 왔다갔다
    
    $(document).ready(function() {
        sidebar();
        
});
    

$(document).on('click', '.toggle', function() {
  // 이벤트 핸들러 코드
    $('.toggle').click(function () {
        // 현재 사이드바의 열림/닫힘 상태 체크
        var isSidebarOpen = $('.sidebar').hasClass('open');

      

        // 사이드바 열림/닫힘 상태 변경
        if (isSidebarOpen) {
            $('.sidebar').removeClass('open').addClass('close');
            $('.sub-menu').addClass('closed'); // 서브 메뉴를 닫음
        } else {
            $('.sidebar').removeClass('close').addClass('open');
        }

        // 열림/닫힘 상태 저장
        localStorage.setItem('isSidebarOpen', !isSidebarOpen);
    });

    // 사이드바 열림/닫힘 상태 초기화
    var isSidebarOpen = localStorage.getItem('isSidebarOpen') === 'true';
    if (isSidebarOpen) {
        $('.sidebar').removeClass('close').addClass('open');
    } else {
        $('.sidebar').removeClass('open').addClass('close');
        $('.sub-menu').addClass('closed'); // 서브 메뉴를 닫음
    }

    // 서브 메뉴 클릭 이벤트
    $('.dropdown-trigger').click(function () {
        // 클릭한 서브 메뉴의 상태 체크
        if ($(this).find('.sub-menu').hasClass('closed')) {
            // 서브 메뉴가 닫힌 상태이면 열림
            $(this).find('.sub-menu').removeClass('closed');
        } else {
            // 서브 메뉴가 열린 상태이면 닫힘
            $(this).find('.sub-menu').addClass('closed');
        }
    });
});


function initSidebar() {
    // 사이드바 열림/닫힘 상태 초기화
    var isSidebarOpen = localStorage.getItem('isSidebarOpen') === 'true';
    if (isSidebarOpen) {
        $('.sidebar').removeClass('close').addClass('open');
    } else {
        $('.sidebar').removeClass('open').addClass('close');
        $('.sub-menu').addClass('closed'); // 서브 메뉴를 닫음
    }


   

    // 서브 메뉴 클릭 이벤트
    $('.dropdown-trigger').click(function () {
        // 클릭한 서브 메뉴의 상태 체크
        if ($(this).find('.sub-menu').hasClass('closed')) {
            // 서브 메뉴가 닫힌 상태이면 열림
            $(this).find('.sub-menu').removeClass('closed');
        } else {
            // 서브 메뉴가 열린 상태이면 닫힘
            $(this).find('.sub-menu').addClass('closed');
        }
    });
}

function toggleSidebar() {


    // Toggle 버튼 클릭 이벤트
    $('.toggle').click(function () {
        // 현재 사이드바의 열림/닫힘 상태 체크
        var isSidebarOpen = $('.sidebar').hasClass('open');

        // 사이드바 열림/닫힘 상태 변경
        if (isSidebarOpen) {
            $('.sidebar').removeClass('open').addClass('close');
            $('.sub-menu').addClass('closed'); // 서브 메뉴를 닫음
            $('.toggle i').removeClass('bi-toggle-on').addClass('bi-toggle-off'); // 토글 버튼 아이콘 변경
        } else {
            $('.sidebar').removeClass('close').addClass('open');
            $('.toggle i').removeClass('bi-toggle-off').addClass('bi-toggle-on'); // 토글 버튼 아이콘 변경
        }

        // 열림/닫힘 상태 저장
        localStorage.setItem('isSidebarOpen', !isSidebarOpen);
    });
 


}

function sidebar() {
    initSidebar();
    toggleSidebar();
}











// $(document).ready(function () {
//     $(".clickmenu > a").click(function () {
//         var $ul = $(this).next("ul");
//         if ($ul.hasClass("hide")) {
//             $(".clickmenu.active > ul").slideUp(300, function () {
//                 $(this).addClass("hide");
//             });
//             $(".clickmenu.active").removeClass("active");
//             $ul.removeClass("hide");
//             $ul.slideDown(300);
//             $(this).parent().addClass("active");
//         } else {
//             $ul.slideUp(300, function () {
//                 $(this).addClass("hide");
//             });
//             $(this).parent().removeClass("active");
//         }
//     });

   
// });




$(document).ready(function () {
    $(".clickmenu").hover(function () {
        var $ul = $(this).find("ul");
        if ($ul.hasClass("hide")) {
            $(".clickmenu.active > ul").slideUp(300, function () {
                $(this).addClass("hide");
            });
            $(".clickmenu.active").removeClass("active");
            $ul.removeClass("hide");
            $ul.slideDown(300);
            $(this).addClass("active");
        }
    }, function () {
        var $ul = $(this).find("ul");
        if (!$ul.hasClass("hide")) {
            $ul.slideUp(300, function () {
                $(this).addClass("hide");
            });
            $(this).removeClass("active");
        }
    });
});






$(document).ready(function () {
  // .clickmenu 요소에 호버 이벤트 등록
  $(document).on('mouseenter', '.clickmenu', function () {
    // 현재 요소의 하위 .sub-menu 요소 토글
    $(this).find('.sub-menu').stop().slideToggle();
  });
});






$(document).ready(function () {
    $(".clickmenu").hover(function () {
        var $ul = $(this).find("ul");
        if ($ul.hasClass("hide")) {
            $(".clickmenu > ul:not(.hide)").slideUp(300, function () {
                $(this).addClass("hide");
            });
            $ul.removeClass("hide");
            $ul.slideDown(300);
        }
    }, function () {
        var $ul = $(this).find("ul");
        if (!$ul.hasClass("hide")) {
            $ul.slideUp(300, function () {
                $(this).addClass("hide");
            });
        }
    });
});



// $('.type-link').on('click', function (event) {
//     event.preventDefault();
//     var value = $(this).attr('data-value');
//     location.href = "<%=contextPath%>/typePage.mi?value=" + value;
// });




$('a.type-link').on('click', function (event) {
    event.preventDefault();
    var form = $('#myForm');
    var value = $(this).find('input[name="value"]').val();
    var categoryName = $(this).find('input[name="categoryName"]').val();
    form.find('input[name="value"]').val(value);
    form.find('input[name="categoryName"]').val(categoryName);
    form.submit();
});




// 업버튼 속성
$(document).ready(function () {
const upBtn = document.getElementById("upBtn");

window.addEventListener("scroll", () => {
    if (window.pageYOffset > 300) {
        upBtn.classList.add("show");
        console.log('와오아ㅗ아오아ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅗ앙');

    } else {
        upBtn.classList.remove("show");
        console.log('와오아ㅗ아ㅁㅁㅅㅅㅅㅅㅅㅅㅅㅅㅅㅅ오아ㅗ앙');
    }

    console.log('와오아ㅗ아오아ㅗ앙');

});

upBtn.addEventListener("click", () => {
    window.scrollTo(0, 0);
});

});



/*
* ---------------------------------------------------------------------------
* Vanilla JavaScript Version
* ---------------------------------------------------------------------------
*/

