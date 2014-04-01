SELECT pokemon.identifier AS pokemonname, moves.identifier as movename, pokemon_move_methods.identifier as learnby, pokemon_moves.level as "level"
FROM pokemon, pokemon_moves, moves, pokemon_move_methods
WHERE pokemon.id == pokemon_moves.pokemon_id AND pokemon_moves.move_id == moves.id AND pokemon_moves.pokemon_move_method_id==pokemon_move_methods.id
GROUP BY pokemon.identifier, moves.identifier
ORDER BY pokemon.id, learnby, level