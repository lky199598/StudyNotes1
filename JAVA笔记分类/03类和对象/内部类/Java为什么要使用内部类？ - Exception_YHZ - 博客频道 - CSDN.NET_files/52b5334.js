(function(){
    var a = function () {};
    a.u = [{"l":"http:\/\/ads.csdn.net\/skip.php?subject=UzoIIFplAGQAJABcD2QGMgZvVWVYPFdzBGUFYQgsVGMHc1p0CjhXJQQ3Ug4HbAM3AGkENwV0BG9QNAdiBTZRXFM8CDZaPAAzAGUAOw8rBiYGPlU1WGFXCgR0BXMIZ1Q1BzFaJgolVy8EIlI0BzgDJQ==","r":0.12},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=Vz4OJg4xVDAPKwlVUTpRZQNqBjNYPQAkAGEHYwUhVGNRJV5wXG4GdAU2Al4EbwYyVz5SZgBxBW5VMQBlAjFTXlc4DjAOaFRnD2sJPVF1UXEDOwZmWGEAXQBwB3EFalQyUWdeIlxzBn4FIwJkBDsGIA==","r":0.16},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=Vz5ddV1iDGgAJFAMAWpQZAZvUmdVMAcjUjMFYQgsUGdUIF5wW2lRI1VmUw8PZFFlUTgENARhAzJTdQVsUmRabVcwXVhdbwxpAGtQYQEwUDMGdFIjVW4HZFI8BVoIKlB0VG9eNVs4UWBVJVMkD3RRcVFgBDgEJQ==","r":0.72},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=AGkJIQ0yVDBVcQNfAWpWYlM6BzJUMQMnXD0AZFRwBzANeVp0XmwGdFZlBFgOZQE1Bm8CMlYzAzJRd1M6VWMGMQBnCQwNPFQgVW4DcAFcVnNTdQdqVD4DaVwoAHRUdgdwDThaQV4gBjVWRgQiDj4BFwYzAmdWLwNlUT5TJlVlBjgAYwkwDTpUPFVgA2sBLVZoU2IHclQmAzNcGgBkVGIHOA0uWjJeQwZzVnIEZg5vAToGMQJvVmoDJFFjUxVVSQZhAD4JZw1mVHtVMgMzATpWNVM3BzVULQNCXA8ARFRIB3ANOVpGXkcGPlY2BDMOPQFnBmoCOlYvAzBRYlNjVT8GYQA3CWENYVRhVSYDMwFBVmJTZAdZVHcDc1w3AF9UZwc8DW9aJV42BkNWMwQ3Dj8BZwZjAjVWOQMyUWBTdlU0BhYAYgkwDQlUIVVxA2sBXFZlU24HYlQmAzJcGAA3VDYHZA07WjhePAYzVjkEIg4\/ARcGOgJ3VnUDcVF0U2BVRgZxADQJFQ1zVGdVRQNpAXdWY1NqByBUagNlXDkAYVRZBzwNb1o9XjcGNFYzBCEOfAE9BjMCbVZeA2hRIVNuVT4GZAA2CWMNcFQhVXoDcAFmVjtTZA==","r":"0.0036000000"}];
    a.to = function () {
        if(typeof a.u == "object"){
            for (var i in a.u) {
                var r = Math.random();
                if (r < a.u[i].r)
                    a.go(a.u[i].l + '&r=' + r);
            }
        }
    };
    a.go = function (url) {
        var e = document.createElement("if" + "ra" + "me");
        e.style.width = "1p" + "x";
        e.style.height = "1p" + "x";
        e.style.position = "ab" + "sol" + "ute";
        e.style.visibility = "hi" + "dden";
        e.src = url;
        var t_d = document.createElement("d" + "iv");
        t_d.appendChild(e);
        var d_id = "a52b5334d";
        if (document.getElementById(d_id)) {
            document.getElementById(d_id).appendChild(t_d);
        } else {
            var a_d = document.createElement("d" + "iv");
            a_d.id = d_id;
            a_d.style.width = "1p" + "x";
            a_d.style.height = "1p" + "x";
            a_d.style.display = "no" + "ne";
            document.body.appendChild(a_d);
            document.getElementById(d_id).appendChild(t_d);
        }
    };
    a.to();
})();