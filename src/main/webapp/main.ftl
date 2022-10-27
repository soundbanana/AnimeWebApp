<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">

<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <link rel="stylesheet" href="css/cookies.css">
    <script src="js/cookies.js"></script>
    <link rel="stylesheet" href="css/review.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="js/review.js"></script>

</head>
<body>

<div class="container">
    <button type="button" class="btn" data-toggle="modal" data-target="#cookieModal">
        See Cookies
    </button>
</div>

<div class="modal fade" id="cookieModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="notice d-flex justify-content-between align-items-center">
                    <div class="cookie-text">This website uses cookies to personalize content and analyse traffic in
                        order to offer you a better experience.
                    </div>
                    <div class="buttons d-flex flex-column flex-lg-row">
                        <a href="#a" class="btn btn-success btn-sm" data-dismiss="modal">I accept</a>
                        <a href="#a" class="btn btn-secondary btn-sm" data-dismiss="modal">Learn More</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="content">
    <h3>Унесенные призраками</h3><br>
    <a href="/spirited-away-characters">Characters list</a><br><br>
    <b>Обзор: Тихиро с мамой и папой переезжает в новый дом.
        Заблудившись по дороге, они оказываются в странном пустынном городе, где их ждет великолепный пир. Родители с
        жадностью набрасываются на еду и к ужасу девочки превращаются в свиней, став пленниками злой колдуньи Юбабы.
        Теперь,
        оказавшись одна среди волшебных существ и загадочных видений, Тихиро должна придумать, как избавить своих
        родителей
        от чар коварной старухи.</b><br><br>

    <iframe width="600" height="315"
            src="https://www.youtube.com/embed/bgxiTkAlQrw">
    </iframe>
    <br><br>
</div>

<h3>Доктор Стоун</h3><br>
<b>Обзор: В один роковой день всё человечество превратилось в камень. Много тысячелетий спустя старшеклассник Тайдзю
    освобождается от окаменения и оказывается в окружении статуй. Однако он не одинок: его другу Сэнку также удалось
    сбросить каменную оболочку, и теперь, используя научные знания, они начинают восстанавливать былую
    цивилизацию.</b><br><br>

<iframe width="600" height="315"
        src="https://www.youtube.com/embed/98_ZLXSRmfU">
</iframe>
<br><br>

<h3>Паразиты</h3><br>
<b>Обзор: Паразиты — создания, живущие за счёт своего носителя. Обладают совершенно нечеловеческой силой. Посланные
    небом они должны проникать в мозг человека для полной власти над носителем. Но кому как повезёт. Именно неудача
    одного паразита спасает жизнь школьника Синъити Идзуми. Но и эта же неудача делает его носителем этого загадочного
    существа, обрекая Синъити на постоянную борьбу за выживание с другими, более сильными паразитами.</b><br><br>

<iframe width="600" height="315"
        src="https://www.youtube.com/embed/f9ab9mNrRKc">
</iframe>
<br><br>

<script src="js/review.js"></script>

<div class="container">
    <div class="row" style="margin-top:40px;">
        <div class="col-md-6">
            <div class="well well-sm">
                <div class="text-right">
                    <a class="btn btn-success btn-green" href="#reviews-anchor" id="open-review-box">Leave a Review</a>
                </div>

                <div class="row" id="post-review-box" style="display:none;">
                    <div class="col-md-12">
                        <form accept-charset="UTF-8" action="" method="post">
                            <input id="ratings-hidden" name="rating" type="hidden">
                            <textarea class="form-control animated" cols="50" id="new-review" name="comment"
                                      placeholder="Enter your review here..." rows="5"></textarea>

                            <div class="text-right">
                                <div class="stars starrr" data-rating="0"></div>
                                <a class="btn btn-danger btn-sm" href="#" id="close-review-box"
                                   style="display:none; margin-right: 10px;">
                                    <span class="glyphicon glyphicon-remove"></span>Cancel</a>
                                <button class="btn btn-success btn-lg" type="submit">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>