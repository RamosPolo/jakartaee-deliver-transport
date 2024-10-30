<form action="/jakartaee-deliver-transport/modifColis" method="POST">
    <input type="hidden" name="id" value="${colis.id}">
    <label for="poid">Poids:</label>
    <input type="text" id="poid" name="poid" value="${colis.poid}"><br>

    <label for="prix">Prix:</label>
    <input type="text" id="prix" name="prix" value="${colis.prix}"><br>

    <!-- Origine (Pair<Long, Long>) -->
    <label for="origine_1">Origine (lattitude) :</label><br>
    <input type="number" id="origine_1" name="origineX" value="${colis.origineX}"><br>

    <label for="origine_2">Origine (longitude) :</label><br>
    <input type="number" id="origine_2" name="origineY" value="${colis.origineY}"><br>

    <!-- Destination (Pair<Long, Long>) -->
    <label for="destination_1">Destination (lattitude) :</label><br>
    <input type="number" id="destination_1" name="destinationX" value="${colis.destinationX}"><br>

    <label for="destination_2">Destination (longitude) :</label><br>
    <input type="number" id="destination_2" name="destinationY" value="${colis.destinationY}"><br>

    <!-- Localisation (Pair<Long, Long>) -->
    <label for="localisation_1">Localisation actuelle (lattitude) :</label><br>
    <input type="number" id="localisation_1" name="localisationX" value="${colis.localisationX}"><br>

    <label for="localisation_2">Localisation actuelle (longitude) :</label><br>
    <input type="number" id="localisation_2" name="localisationY" value="${colis.localisationY}"><br>

    <!-- État du colis -->
    <label for="etat">Etat du colis :</label><br>
    <input type="text" id="etat" name="etat" value="${colis.etat}"><br><br>

    <button type="submit">Enregistrer les modifications</button>
</form>