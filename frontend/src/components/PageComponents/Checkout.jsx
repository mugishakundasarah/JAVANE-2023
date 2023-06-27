import { useState } from "react";
import axios from "axios";
import { BASE_URL } from "../../utils/BaseUrl";
import authHeader from "../../utils/BearerAuth";

const Checkout = ({ cartItems }) => {
  const [checkoutError, setCheckoutError] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  const handleCheckout = async () => {
    setIsLoading(true);

    try {
      // Make a POST request to your backend API to perform the checkout
      await axios.post(`${BASE_URL}/check-out`, cartItems, { headers: authHeader()});
      setIsLoading(false);
      // Handle successful checkout
      // Clear the cart or perform any other necessary actions
    } catch (error) {
      setIsLoading(false);
      setCheckoutError("Error occurred during checkout. Please try again.");
    }
  };

  return (
    <div className="container mx-auto mt-8">
      <h1 className="text-2xl font-semibold mb-4">Checkout</h1>
      {cartItems.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <>
          {cartItems.map((item) => (
            <div key={item.id} className="flex items-center justify-between p-4 border border-gray-300 rounded-md mb-4">
              <div>
                <h3 className="text-lg font-semibold">{item.name}</h3>
                <p className="text-gray-500">Price: ${item.price}</p>
                <p className="text-gray-500">Quantity: {item.quantity}</p>
              </div>
              <p className="text-gray-500">Total: ${item.price * item.quantity}</p>
            </div>
          ))}
          <button
            onClick={handleCheckout}
            className="px-4 py-2 text-sm font-semibold text-white bg-blue-500 rounded hover:bg-blue-600 focus:bg-blue-600"
            disabled={isLoading}
          >
            {isLoading ? "Processing..." : "Checkout"}
          </button>
          {checkoutError && <p className="text-red-500 mt-2">{checkoutError}</p>}
        </>
      )}
    </div>
  );
};

export default Checkout;
