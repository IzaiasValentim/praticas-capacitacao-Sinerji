function OrderDeatils({ itemsInBag }) {

    function calculateTotal() {

        // Função que calcula o total do pedido e retorna com duas casas decimais.
        
        let orderTotal = 0;
        itemsInBag.forEach(item => orderTotal += item.price * item.quantity);
        return orderTotal.toFixed(2);
    }

    return (

        <>
            <section className="summary">
                <strong>Order Details</strong>
                <table>
                    <thead>
                        <tr>
                            <th>Item</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>

                        {/* Aqui é exibido as informações de um pedido de acordo com os items presentes em itemsInBag.*/}

                        {itemsInBag.map((item) =>
                            <tr key={item.id}>
                                <td>{item.quantity}x {item.name}</td>
                                <td>$ {(item.quantity * item.price).toFixed(2)}</td>
                            </tr>
                        )}

                        <tr>
                            <th>Total</th>
                            <th>$ {calculateTotal()}</th>
                        </tr>

                    </tbody>
                </table>
            </section>
        </>
    )
}

export default OrderDeatils