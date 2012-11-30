<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="navbar navbar-inverse">
    <div class="navbar-inner">
       <a href="/"> <span class="brand">Todooz</span></a>
        <form method="get" action="/search" class="navbar-search pull-left">
            <input type="text" name="query" class="search-query" placeholder="Search">
        </form>
        <a href="/add" class="btn btn-inverse pull-right"><i class="icon-plus icon-white"></i></a>
    </div>
</div>