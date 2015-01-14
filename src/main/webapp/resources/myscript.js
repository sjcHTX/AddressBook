$(document)
			.ready(
					function() {
						var max_fields = 10; //maximum input boxes allowed						
						var add_button = $(".add_field_button"); //Add button ID

						var x = 1; //inital text box count
						$(add_button)
								.click(
										function(e) { //on add input button click
											e.preventDefault();
											if (x < max_fields) { //max input box allowed												
												$(".input_fields_wrap").replaceWith('<tr><td><label for="addresses['+x+'].address">Address '+(x+1)+'</label></td><td><input type="text" name="addresses['+x+'].address"/></td><td><select name="addresses['+x+'].addressType"><option value="HOME">Home</option><option value="BUSINESS">Business</option></select></td><td><button class="remove_field">Remove</button></td></tr><tr class="input_fields_wrap"></tr>');
												x++; //text box increment
											}
										});

						$(".remove_field").click(
								function(e) { //user click on remove text
									e.preventDefault();
									alert("remove");
									$(this).parent().parent().remove();
									x--;
								}
						);
					});