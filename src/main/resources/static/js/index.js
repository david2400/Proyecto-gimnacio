$(document).ready(function() {
    $('#tablaSala').load("./static/includes/tablaSala.html");

    $("#panel-admin").css("display", "none");

    $('.open').click(function() {
        $("#panel-admin").animate({ width: 'toggle' }, 100);
    });

    if (!document.getElementById('wrapper').className && !localStorage.getItem("selectedColor")) {
        console.log('in if');
        document.getElementById('wrapper').classList.add('blue');
    } else {
        console.log('else');
        var colorClass = localStorage.getItem("selectedColor");
        document.getElementById('wrapper').classList.add(colorClass);
    }


    $('.panel-group').on('hidden.bs.collapse', toggleIcon);
    $('.panel-group').on('shown.bs.collapse', toggleIcon);

});




function toggleIcon(e) {
    $(e.target)
        .prev('.panel-heading')
        .find(".more-less")
        .toggleClass('fa-plus fa-minus');
}

function mytheme(index) {
    switch (index) {
        case 0:
            changeColor('orange');
            break;
        case 1:
            changeColor('orange');
            break;
        case 2:
            changeColor('orange');
            break;
        case 3:
            changeColor('orange');
            break;
        case 4:
            changeColor('orange');
            break;
        case 5:
            changeColor('orange');
            break;
        default:
            changeColor('orange');
    }
    var selectedClass = document.getElementById('wrapper').className;
    localStorage.setItem("selectedColor", selectedClass);
}

function changeColor(color) {
    $('#wrapper').removeClass();
    $('#wrapper').addClass(color);
}