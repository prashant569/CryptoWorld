/**
 * 
 */

var f = function(){
	
	$('#fulldata').hide();
}

$(document).ready(function() {
	
    var table = $('#fulldata').DataTable({
    	
    	 "order": [[2, "desc" ]]
    });
    

    $('#fulldata tbody')
    .on( 'mouseenter', 'td', function () {
        var colIdx = table.cell(this).index().column;

        $( table.cells().nodes() ).removeClass( 'highlight' );
        $( table.column( colIdx ).nodes() ).addClass( 'highlight');
    } );
    
} );
