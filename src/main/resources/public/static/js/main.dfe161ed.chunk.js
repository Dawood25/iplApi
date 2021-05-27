(this.webpackJsonpfrontend=this.webpackJsonpfrontend||[]).push([[0],{25:function(e,t,c){},26:function(e,t,c){},28:function(e,t,c){},29:function(e,t,c){},36:function(e,t,c){},37:function(e,t,c){},38:function(e,t,c){},39:function(e,t,c){"use strict";c.r(t);var n=c(1),a=c.n(n),s=c(18),r=c.n(s),i=(c(25),c(26),c(4)),l=c(2),j=c(8),h=c.n(j),o=c(10),m=c(11),d=(c(28),c(29),c(0)),u=function(e){var t=e.teamName,c=e.matches;if(!c)return null;var n=t===c.team1?c.team2:c.team1,a=t===c.winner,s="/teams/".concat(n);return Object(d.jsxs)("div",{className:a?"win-card MatchDetailCard":"loss-card MatchDetailCard",children:[Object(d.jsxs)("div",{children:[Object(d.jsx)("span",{className:"vs",children:"vs"}),Object(d.jsx)("h3",{children:Object(d.jsxs)(i.b,{to:s,children:[" ",n]})}),Object(d.jsxs)("h3",{className:"match-venue",children:["At ",c.venue]}),Object(d.jsxs)("h3",{className:"match-date",children:["on ",c.date]}),Object(d.jsxs)("h3",{className:"match-result",children:[c.winner," won by ",c.resultMargin," ",c.result]})]}),Object(d.jsxs)("div",{className:"additional-details",children:[Object(d.jsx)("h3",{children:"First Inings"}),Object(d.jsx)("p",{children:c.team1}),Object(d.jsx)("h3",{children:"Second Inings"}),Object(d.jsx)("p",{children:c.team2}),Object(d.jsx)("h3",{children:"Man of the Match"}),Object(d.jsx)("p",{children:c.playerOfMatch}),Object(d.jsx)("h3",{children:"Umpire"}),Object(d.jsxs)("p",{children:[c.umpire1,",",c.umpire2]})]})]})},b=(c(36),function(e){var t=e.teamName,c=e.matches,n=t===c.team1?c.team2:c.team1,a="/teams/".concat(n),s=t===c.winner;return Object(d.jsxs)("div",{className:s?"MatchSmallCard win-card":"MatchSmallCard loss-card",children:[Object(d.jsx)("p",{children:"vs "}),Object(d.jsx)("h4",{children:Object(d.jsxs)(i.b,{to:a,children:[" ",n]})}),Object(d.jsxs)("p",{children:[c.winner," won by ",c.resultMargin," ",c.result]})]})}),O=c(20),x=function(){var e=Object(n.useState)({matches:[]}),t=Object(m.a)(e,2),c=t[0],a=t[1],s=Object(l.f)().teamName;return Object(n.useEffect)((function(){(function(){var e=Object(o.a)(h.a.mark((function e(){var t,c;return h.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch("http://localhost:8080/teams/".concat(s));case 2:return t=e.sent,e.next=5,t.json();case 5:c=e.sent,console.log(c),a(c);case 8:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()()}),[s]),c&&c.name?Object(d.jsxs)("div",{className:"TeamPage",children:[Object(d.jsx)("div",{className:"team-name-section",children:Object(d.jsx)("h2",{className:"team-name",children:c.name})}),Object(d.jsxs)("div",{className:"percent-section",children:[Object(d.jsx)("div",{className:"chart",children:"Graph Win/Loss"}),Object(d.jsx)("div",{className:"piegraph",children:Object(d.jsx)(O.PieChart,{data:[{title:"Tie/Losses",value:c.totalMatches-c.matchWon,color:"#EC373F"},{title:"Win",value:c.matchWon,color:"#40923D"}],label:function(e){return e.dataEntry.title},labelStyle:function(e){return{fill:"white",fontSize:"10px"}}})})]}),Object(d.jsx)("div",{className:"detail-section",children:Object(d.jsx)(u,{teamName:c.name,matches:c.matches[0]})}),c.matches.slice(1).map((function(e){return Object(d.jsx)(b,{teamName:c.name,matches:e},e.id)})),Object(d.jsx)("div",{className:"more-link",children:Object(d.jsx)("a",{href:"http://localhost:3000/teams/".concat(s,"/matches/2020"),children:"More Link >"})})]}):Object(d.jsx)("h2",{children:"Team Not Found"})},f=function(e){var t=e.teamName,c=e.year;return Object(d.jsx)(i.b,{to:"/teams/".concat(t,"/matches/").concat(c),children:c})},p=(c(37),function(){var e=Object(n.useState)([]),t=Object(m.a)(e,2),c=t[0],a=t[1],s=Object(l.f)(),r=s.teamName,i=s.year,j=[];Object(n.useEffect)((function(){(function(){var e=Object(o.a)(h.a.mark((function e(){var t,c;return h.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch("http://localhost:8080/teams/".concat(r,"/matches?year=").concat(i));case 2:return t=e.sent,e.next=5,t.json();case 5:c=e.sent,console.log(c),a(c);case 8:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()(),console.log("hello world")}),[r,i]);for(var b=2008;b<=2020;b++)j.push(b);return Object(d.jsxs)("div",{className:"MatchPage",children:[Object(d.jsxs)("div",{className:"yearSelector",children:[Object(d.jsx)("h3",{className:"page-heading",children:" Select Year"}),Object(d.jsx)("ol",{children:j.map((function(e){return Object(d.jsx)("li",{children:Object(d.jsx)(f,{teamName:r,year:e},e)})}))})]}),Object(d.jsxs)("div",{children:[Object(d.jsx)("h1",{children:r}),c.map((function(e){return Object(d.jsx)(u,{teamName:r,matches:e},e.id)}))]})]})}),v=(c(38),function(e){var t=e.match;return Object(d.jsx)("div",{className:"TeamName",children:Object(d.jsx)("div",{children:Object(d.jsx)(i.b,{to:"/teams/".concat(t.name),children:t.name})},t.teamId)})}),N=function(){var e=Object(n.useState)([{}]),t=Object(m.a)(e,2),c=t[0],a=t[1];return Object(n.useEffect)((function(){(function(){var e=Object(o.a)(h.a.mark((function e(){var t,c;return h.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch("http://localhost:8080/Allteams");case 2:return t=e.sent,e.next=5,t.json();case 5:c=e.sent,console.log(c),a(c);case 8:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()(),console.log(c)}),[]),Object(d.jsx)("div",{className:"AllTeams",children:c.map((function(e){return Object(d.jsx)(v,{match:e})}))})};var g=function(){return Object(d.jsx)("div",{className:"App",children:Object(d.jsxs)(i.a,{children:[Object(d.jsx)("h1",{children:Object(d.jsx)(i.b,{to:"/team",children:"IPL Dashboard"})}),Object(d.jsxs)(l.c,{children:[Object(d.jsx)(l.a,{path:"/teams/:teamName/matches/:year",children:Object(d.jsx)(p,{})}),Object(d.jsx)(l.a,{path:"/teams/:teamName",children:Object(d.jsx)(x,{})}),Object(d.jsx)(l.a,{path:"/",children:Object(d.jsx)(N,{})})]})]})})},w=function(e){e&&e instanceof Function&&c.e(3).then(c.bind(null,40)).then((function(t){var c=t.getCLS,n=t.getFID,a=t.getFCP,s=t.getLCP,r=t.getTTFB;c(e),n(e),a(e),s(e),r(e)}))};r.a.render(Object(d.jsx)(a.a.StrictMode,{children:Object(d.jsx)(g,{})}),document.getElementById("root")),w()}},[[39,1,2]]]);
//# sourceMappingURL=main.dfe161ed.chunk.js.map