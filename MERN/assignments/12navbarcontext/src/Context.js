import React from "react";

const Context = React.createContext();

// export const ContextProvider = ({ children }) => {
//     const [name, setName] = useState("");

//     return (
//         <Context.Provider value={{ name, setName }}>
//             {children}
//         </Context.Provider>
//     );
// };

export default Context;
