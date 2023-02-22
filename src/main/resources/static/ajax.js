//버튼을 누르면 뭘 한다.라는 동적 스크립트 작성
/*
$(function(){
    //button id에 이벤트 걸어주기
    $('#more').click(function (){
        //클릭된지 확ㄱ인
        //서버에서뭘하고
        //서버에서 응답완료되었는지
        //에러처리
        $.ajax({
            //여기코드는 비동기 스크립트다.
            //서버에게 뭘보내줘 get이든 post 이든
        }).done(function (response){
            //이 함수 호출해ㅜ렴
            //단, 완료된 경우만
        }).always(function (response){

        })
    })
})

 */

$(function(){
    $("#more").click(function() {
        console.log("clicked");
        var last_page = parseInt($(this).attr("last-page")) + 1; //이버튼에 마지막까지 읽은 값을 기록해둘것

        $.ajax({
            method:"GET",
            url: "/api/getNextList",
            data : {"page":last_page}
        })
            .done(function(response){
                console.log("done");
                console.log(response);
                if(response.length > 0) {
                    for(var blog of response) {
                        $("#more-blogs").append(
                            "<div>" +
                            "<a href=\"#\">" +
                            "<h2>" + blog.title + "</h2>" +
                            "<h3>" + blog.content + "</h3>" +
                            "</a>" +
                            "<p>" +
                            "Bloged by " + blog.username +
                            "</p>" +
                            "</div>"
                        );
                    }
                }
                else {
                    alert('last data');
                }
            })
            .fail(function (e){
                console.log("fail")
                console.log(e);
            })
            .always(function(response){
                console.log("always");
                console.log(response);
            });
        $(this).attr("last-page", last_page); //값 갱신
    });
});