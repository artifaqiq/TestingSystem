/**
 * Created by Artur Lomako on 4/17/17.
 */

$(document).ready(function() {
    if(!$('#myCanvas').tagcanvas({
            outlineColour: '#ff00ff',
            reverse: true,
            depth: 0.8,
            maxSpeed: 0.05,
            textFont: null,
            textColour: null,
            weightMode:'both',
            weight: true,
            weightGradient: {
                0:    '#f00',
                1:    '#00f'
            }
        },'tags')) {
        $('#myCanvasContainer').hide();
    }
});